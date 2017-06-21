package com.callegasdev.app;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import rx.Observable;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private Pets30Resource pets30Resource;

    public RxNettyHandler(Pets30Resource pets30Resource) {
        this.pets30Resource = pets30Resource;
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
        if (request.getUri().startsWith("/petsWith30Years")) {
                response.setStatus(HttpResponseStatus.OK);
                return response.writeStringAndFlush(pets30Resource.find());
        } else {
            response.setStatus(HttpResponseStatus.NOT_FOUND);
            return response.close();
        }
    }
}