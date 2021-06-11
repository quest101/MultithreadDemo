package com.ken.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class PlainNio2EchoServer {

    public void serve(int port) throws IOException {
        System.out.println("Listening for connections on port " + port);
        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(port);
        // Bind Server to port
        serverChannel.bind(address);
        final CountDownLatch latch = new CountDownLatch(1);
        // Start to accept new Client connections.
        // Once one is accepted the CompletionHandler will get called.
        serverChannel.accept(null, new CompletionHandler() {
            //@Override
            public void completed(
                    final AsynchronousSocketChannel channel, Object attachment) {
                // Again accept new Client connections
                serverChannel.accept(null, this);
                ByteBuffer buffer = ByteBuffer.allocate(100);
                // Trigger a read operation on the Channel,
                // the given CompletionHandler will be notified once something was read
                channel.read(buffer, buffer, new EchoCompletionHandler(channel));
            }

            @Override
            public void completed(Object result, Object attachment) {

            }

            @Override
            public void failed(Throwable throwable, Object attachment) {
                try {
                    // Close the socket on error
                    serverChannel.close();
                } catch (IOException e) {
                    // ingnore on close
                } finally {
                    latch.countDown();
                }
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private final class EchoCompletionHandler implements CompletionHandler {
        private final AsynchronousSocketChannel channel;

        EchoCompletionHandler(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        //@Override
        public void completed(Integer result, ByteBuffer buffer) {
            buffer.flip();
            // Trigger a write operation on the Channel,
            // the given CompletionHandler will be notified once something was written
            channel.write(buffer, buffer, new CompletionHandler() {
                @Override
                public void completed(Object result, Object attachment) {

                }

                @Override
                public void failed(Throwable exc, Object attachment) {

                }

                //@Override
                public void completed(Integer result, ByteBuffer buffer) {
                    if (buffer.hasRemaining()) {
                        // Trigger again a write operation if something is left in the ByteBuffer
                        channel.write(buffer, buffer, this);
                    } else {
                        buffer.compact();
                        // Trigger a read operation on the Channel,
                        // the given CompletionHandler will be notified once something was read
                        channel.read(buffer, buffer, PlainNio2EchoServer.EchoCompletionHandler.this);
                    }
                }

                //@Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) { // ingnore on close
                    }
                }
            });
        }

        //@Override
        public void failed(Throwable exc, ByteBuffer attachment) {
            try {
                channel.close();
            } catch (IOException e) { // ingnore on close } }
            }
        }

        @Override
        public void completed(Object result, Object attachment) {

        }

        @Override
        public void failed(Throwable exc, Object attachment) {

        }
    }

}
