package com.opendevup.shop.application.usecases;

public interface UseCase<Request, Response> {
    Response execute(Request request);
}
