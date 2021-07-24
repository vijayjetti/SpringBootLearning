package com.vijay.springbootlearning.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class URLConstants {

    public static final String TEST_URL = "/test/hello";

    public static final String CUSTOMER_BASE_URL = "/customer";
    public static final String GET = "/{id}";
    public static final String GET_LIST = "/customers";
    public static final String ADD = "/addCustomer";
    public static final String ADD_LIST =  "/addCustomers";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete/{Id}";


    public static final String GET_USER = "/user/{userId}";
    public static final String GET_USER_LIST = "/user/users";
    public static final String ADD_USER = "/user/addUser";
    public static final String UPDATE_USER = "/user/updateUser";
    public static final String PATCH_USER = "/user/patchUser";
    public static final String DELETE_USER = "/user/deleteUser/{userId}";
    public static final String CHECK_EXISTING_USER = "/user/chekExistingUser/{userId}";
    public static final String USER_SUCCESS_RESPONSE = "/user/success";
    public static final String USER_FAILUER_RESPONSE = "/user/failure";

    public static final String LOGIN_TOKEN_URL = "/login/token";

}
