package com.upskillyourself.list.service;

import com.upskillyourself.list.core.service.TodoService;
import com.upskillyourself.list.exchange.request.UserRequest;
import com.upskillyourself.list.exchange.response.UserResponse;

public interface CreateUserService extends TodoService<UserRequest, UserResponse> {
}
