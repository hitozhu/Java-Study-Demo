#### 相关概念
* 缓冲区（buffer）
* 管道（channel）
* 选择器（selector）


#### 缓冲区（buffer）
> 一种基本数据类型对应一种缓冲区类型（boolean 类型除外）
* ByteBuffer
* CharBuffer
* ShortBuffer
* IntBuffer
* LongBuffer
* FloatBuffer
* DoubleBuffer

#### 管道（channel）
* FileChannel：文件
* DatagramChannel：UDP
* SocketChannel：套接字（客户端）
* ServerSocketChannel：套接字（服务端）

#### 选择器（selector）
> 管道注册到选择器上并监听管道对应的事件，当管道准备就绪时，切换到就绪的管道上，处理请求。



[NIO 参考地址](https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html)
