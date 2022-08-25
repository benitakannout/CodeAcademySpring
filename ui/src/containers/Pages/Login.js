import React from "react";

const Login = () => {

    function sendLoginRequest() {
        console.log("Request");
    }

    return (
        <>
            <div>
                <label form="username">Username</label>
                <input type="email" id="username"/>
            </div>
            <div>
                <label form="password">Password</label>
                <input type="password" id="password"/>
            </div>
            <div>
                <button id="submit" type="button" onClick={() => sendLoginRequest()}>Login</button>
            </div>
        </>
    );
};

export default Login;
