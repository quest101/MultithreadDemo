package com.ken.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class Server {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {

            ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);

            while(true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                byteBuffer.flip();//切换模式  写-->读

                int effective = socketChannel.read(byteBuffer);

            }

        } catch (IOException e){

        }
    }

}
