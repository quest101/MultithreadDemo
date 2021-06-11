package com.kang.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {

            ServerSocketChannel serverSocketChannel= ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(8080));
            //����Ϊ������
            serverSocketChannel.configureBlocking(false);

            while(true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                byteBuffer.flip();//�л�ģʽ  д-->��

                int effective = socketChannel.read(byteBuffer);

            }

        } catch (IOException e){

        }
    }

}
