package netty;import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/**
 * @ClassName: HelloServiceHandler
 * @Description:
 * @author ZXY
 * @date 2016/8/1 10:56
 */
public class ServerHandler extends ChannelHandlerAdapter {
    int counter = 0;
    private static final String MESSAGE = "It greatly simplifies and streamlines network programming such as TCP and UDP socket server.";

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("==============channel-register==============");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("==============channel-active==============");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        System.out.println("接收客户端msg:[" + msg + "]");
        ByteBuf echo = Unpooled.copiedBuffer(MESSAGE.getBytes());
        ctx.writeAndFlush(echo);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("==============channel-read-complete==============");
        ctx.flush();
    }

    @Override
    public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        System.out.println("==============disconnect==============");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
