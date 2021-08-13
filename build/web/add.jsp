<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Registration</title>
        <style>
            /*body {
                    font-family: Verdana, Geneva, sans-serif;
                    font-size: 14px;
                    background: #f2f2f2;
            }
            .clearfix {
                    &:after {
                            content: "";
                            display: block;
                            clear: both;
                            visibility: hidden;
                            height: 0;
                    }
            }
            .form_wrapper {
                    background: #fff;
                    width: 400px;
                    max-width: 100%;
                    box-sizing: border-box;
                    padding: 25px;
                    margin: 8% auto 0;
                    position: relative;
                    z-index: 1;
                    border-top: 5px solid $yellow;
                    -webkit-box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
                    -moz-box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
                    box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
                -webkit-transform-origin: 50% 0%;
                transform-origin: 50% 0%;
                -webkit-transform: scale3d(1, 1, 1);
                transform: scale3d(1, 1, 1);
                -webkit-transition: none;
                transition: none;
                -webkit-animation: expand 0.8s 0.6s ease-out forwards;
                animation: expand 0.8s 0.6s ease-out forwards;
                opacity: 0;
                    h2 {
                            font-size: 1.5em;
                            line-height: 1.5em;
                            margin: 0;
                    }
                    .title_container {
                            text-align: center;
                            padding-bottom: 15px;
                    }
                    h3 {
                            font-size: 1.1em;
                            font-weight: normal;
                            line-height: 1.5em;
                            margin: 0;
                    }
                label {
                    font-size: 12px;
                }
                    .row {
                            margin: 10px -15px;
                            >div {
                                    padding: 0 15px;
                                    box-sizing: border-box;
                            }
                    }
                    .col_half {
                            width: 50%;
                            float: left;
                    }
                    .input_field {
                            position: relative;
                            margin-bottom: 20px;
                    -webkit-animation: bounce 0.6s ease-out;
                         animation: bounce 0.6s ease-out;
                            >span {
                                    position: absolute;
                                    left: 0;
                                    top: 0;
                                    color: #333;
                                    height: 100%;
                                    border-right: 1px solid #cccccc;
                                    text-align: center;
                                    width: 30px;
                                    >i {
                                            padding-top: 10px;
                                    }
                            }
                    }
                    .textarea_field {
                            >span {
                                    >i {
                                            padding-top: 10px;
                                    }
                            }
                    }
                    input {
                &[type="text"], &[type="email"], &[type="password"] {
                  width: 100%;
                  padding: 8px 10px 9px 35px;
                  height: 35px;
                  border: 1px solid #cccccc;
                  box-sizing: border-box;
                  outline: none;
                  -webkit-transition: all 0.30s ease-in-out;
                  -moz-transition: all 0.30s ease-in-out;
                  -ms-transition: all 0.30s ease-in-out;
                  transition: all 0.30s ease-in-out;
                }
                &[type="text"]:hover, &[type="email"]:hover, &[type="password"]:hover {
                  background: #fafafa;
                }
                &[type="text"]:focus, &[type="email"]:focus, &[type="password"]:focus {
                  -webkit-box-shadow: 0 0 2px 1px rgba(255, 169, 0, 0.5);
                  -moz-box-shadow: 0 0 2px 1px rgba(255, 169, 0, 0.5);
                  box-shadow: 0 0 2px 1px rgba(255, 169, 0, 0.5);
                  border: 1px solid $yellow;
                  background: #fafafa;
                }
                &[type="submit"] {
                            background: #f5ba1a;
                            height: 35px;
                            line-height: 35px;
                            width: 100%;
                            border: none;
                            outline: none;
                            cursor: pointer;
                            color: #fff;
                            font-size: 1.1em;
                            margin-bottom: 10px;
                            -webkit-transition: all 0.30s ease-in-out;
                            -moz-transition: all 0.30s ease-in-out;
                            -ms-transition: all 0.30s ease-in-out;
                            transition: all 0.30s ease-in-out;
                            &:hover {
                                    background: darken(#f5ba1a,7%);
                            }
                            &:focus {
                                    background: darken(#f5ba1a,7%);
                            }
                    }    
                &[type="checkbox"], &[type="radio"] {
                  border: 0;
                  clip: rect(0 0 0 0);
                  height: 1px;
                  margin: -1px;
                  overflow: hidden;
                  padding: 0;
                  position: absolute;
                  width: 1px;
                }
              }
            }
            .form_container {
                    .row {
                            .col_half.last {
                                    border-left: 1px solid #cccccc;
                            }
                    }
            }
            .checkbox_option{
                label{
                    margin-right: 1em;
                    position: relative;
                    &:before {
                      content: "";
                      display: inline-block;
                      width: 0.5em;
                      height: 0.5em;
                      margin-right: 0.5em;
                      vertical-align: -2px;
                      border: 2px solid #cccccc;
                      padding: 0.12em;
                      background-color: transparent;
                      background-clip: content-box;
                      transition: all 0.2s ease;
                    }
                    &:after {
                      border-right: 2px solid #000000;
                      border-top: 2px solid #000000;
                      content: "";
                      height: 20px;
                      left: 2px;
                      position: absolute;
                      top: 7px;
                      transform: scaleX(-1) rotate(135deg);
                      transform-origin: left top;
                      width: 7px;
                      display: none;
                    }
                }
                input {
                &:hover + label:before {
                  border-color: #000000;
                }
                &:checked + label {
                  &:before {
                    border-color: #000000;
                  }
                  &:after {
                    -moz-animation: check 0.8s ease 0s running;
                    -webkit-animation: check 0.8s ease 0s running;
                    animation: check 0.8s ease 0s running;
                    display: block;
                    width: 7px;
                    height: 20px;
                    border-color: #000000;
                  }
                }
              }
            }
            .radio_option {
              label {
                  margin-right: 1em;
                &:before {
                  content: "";
                  display: inline-block;
                  width: 0.5em;
                  height: 0.5em;
                  margin-right: 0.5em;
                  border-radius: 100%;
                  vertical-align: -3px;
                  border: 2px solid #cccccc;
                  padding: 0.15em;
                  background-color: transparent;
                  background-clip: content-box;
                  transition: all 0.2s ease;
                }
              }
              input {
                &:hover + label:before {
                  border-color: #000000;
                }
                &:checked + label:before {
                  background-color: #000000;
                  border-color: #000000;
                }
              }
            }
            .select_option {
              position: relative;
              width: 100%;
              select {
                display: inline-block;
                width: 100%;
                height: 35px;
                padding: 0px 15px;
                cursor: pointer;
                color: #7b7b7b;
                border: 1px solid #cccccc;
                border-radius: 0;
                background: #fff;
                appearance: none;
                -webkit-appearance: none;
                -moz-appearance: none;
                transition: all 0.2s ease;
                &::-ms-expand {
                  display: none;
                }
                &:hover, &:focus {
                  color: #000000;
                  background: #fafafa;
                  border-color: #000000;
                  outline: none;
                }
              }
            }
            .select_arrow {
              position: absolute;
              top: calc(50% - 4px);
              right: 15px;
              width: 0;
              height: 0;
              pointer-events: none;
              border-width: 8px 5px 0 5px;
              border-style: solid;
              border-color: #7b7b7b transparent transparent transparent;
            }
            
            .select_option select {
              &:hover + .select_arrow, &:focus + .select_arrow {
                border-top-color: #000000;
              }
            }
            .credit {
                    position: relative;
                    z-index: 1;
                    text-align: center;
                    padding: 15px;
                    color: #f5ba1a;
                    a {
                            color: darken(#f5ba1a,7%);
                    }
            }
            @-webkit-keyframes check {
              0% { height: 0; width: 0; }
              25% { height: 0; width: 7px; }
              50% { height: 20px; width: 7px; }
            }
            
            @keyframes check {
              0% { height: 0; width: 0; }
              25% { height: 0; width: 7px; }
              50% { height: 20px; width: 7px; }
            }
            
            @-webkit-keyframes expand { 
                    0% { -webkit-transform: scale3d(1,0,1); opacity:0; }
                    25% { -webkit-transform: scale3d(1,1.2,1); }
                    50% { -webkit-transform: scale3d(1,0.85,1); }
                    75% { -webkit-transform: scale3d(1,1.05,1); }
                    100% { -webkit-transform: scale3d(1,1,1);  opacity:1; }
            }
            
            @keyframes expand { 
                    0% { -webkit-transform: scale3d(1,0,1); transform: scale3d(1,0,1);  opacity:0; }
                    25% { -webkit-transform: scale3d(1,1.2,1); transform: scale3d(1,1.2,1); }
                    50% { -webkit-transform: scale3d(1,0.85,1); transform: scale3d(1,0.85,1); }
                    75% { -webkit-transform: scale3d(1,1.05,1); transform: scale3d(1,1.05,1); }
                    100% { -webkit-transform: scale3d(1,1,1); transform: scale3d(1,1,1);  opacity:1; }
            }
            
            
            @-webkit-keyframes bounce { 
                    0% { -webkit-transform: translate3d(0,-25px,0); opacity:0; }
                    25% { -webkit-transform: translate3d(0,10px,0); }
                    50% { -webkit-transform: translate3d(0,-6px,0); }
                    75% { -webkit-transform: translate3d(0,2px,0); }
                    100% { -webkit-transform: translate3d(0,0,0); opacity: 1; }
            }
            
            @keyframes bounce { 
                    0% { -webkit-transform: translate3d(0,-25px,0); transform: translate3d(0,-25px,0); opacity:0; }
                    25% { -webkit-transform: translate3d(0,10px,0); transform: translate3d(0,10px,0); }
                    50% { -webkit-transform: translate3d(0,-6px,0); transform: translate3d(0,-6px,0); }
                    75% { -webkit-transform: translate3d(0,2px,0); transform: translate3d(0,2px,0); }
                    100% { -webkit-transform: translate3d(0,0,0); transform: translate3d(0,0,0); opacity: 1; }
            }
            @media (max-width: 600px) {
                    .form_wrapper {
                            .col_half {
                                    width: 100%;
                                    float: none;
                            }
                    }
                    .bottom_row {
                            .col_half {
                                    width: 50%;
                                    float: left;
                            }
                    }
                    .form_container {
                            .row {
                                    .col_half.last {
                                            border-left: none;
                                    }
                            }
                    }
                    .remember_me {
                            padding-bottom: 20px;
                    }
            }*/body {
                background-image: url('	https://tipsmake.com/data/images/beautiful-technology-background-picture-1-TDsP3Qvos.jpg');
                padding: 50px;
            }
            /*            form
                        {align-content:center;
                         text-align: center;
            
                        }*/
            h1{
                color: white
            }
            a{
                color: red;         
            }
            .relative{
                height:350px;
                width: 350px;
                position: relative;
                left: 30%;
                top: 50%; 

            }
            * {
                margin: 0;
                padding: 0;
            }
            .form-tt {
                width: 400px;
                border-radius: 10px;
                overflow: hidden;
                padding: 55px 55px 37px;
                background: #9152f8;
                background: -webkit-linear-gradient(top,#7579ff,#b224ef);
                background: -o-linear-gradient(top,#7579ff,#b224ef);
                background: -moz-linear-gradient(top,#7579ff,#b224ef);
                background: linear-gradient(top,#7579ff,#b224ef);
                text-align: center;
            }
            .form-tt h1 {
                font-size: 30px;
                color: #fff;
                line-height: 1.2;
                text-align: center;
                text-transform: uppercase;
                display: block;
                margin-bottom: 30px;
            }

            .form-tt input[type=text], .form-tt input[type=password] {
                font-family: Poppins-Regular;
                font-size: 16px;
                color: #fff;
                line-height: 1.2;
                display: block;
                width: calc(100% - 10px);
                height: 45px;
                background: 0 0;
                padding: 10px 0;
                border-bottom: 2px solid rgba(255,255,255,.24)!important;
                border: 0;
                outline: 0;
            }
            .form-tt input[type=text]::focus, .form-tt input[type=password]::focus {
                color: red;
            }
            .form-tt input[type=password] {
                margin-bottom: 20px;
            }
            .form-tt input::placeholder {
                color: #fff;
            }
            .checkbox {
                display: block;
            }
            .form-tt input[type=submit] {
                font-size: 16px;
                color: #555;
                line-height: 1.2;
                padding: 0 20px;
                min-width: 120px;
                height: 50px;
                border-radius: 25px;
                background: #fff;
                position: relative;
                z-index: 1;
                border: 0;
                outline: 0;
                display: block;
                margin: 30px auto;
            }
            #checkbox {
                display: inline-block;
                margin-right: 10px;
            }
            .checkbox-text {
                color: #fff;
            }
            .psw-text {
                color: #fff;
            }
        </style>
    </head>
    <body>
        <div class="form-tt" style="position: relative;
                left: 30%;
                top: 50%;">
        <h3>Registration Form</h3>
        <form:form method="POST" action="${request.contextPath}/spring-login/${actions}" commandName="user">
            <table>
                <tr><td><form:hidden  path="id" value="${user.getId()}" /></td></tr>
                <tr><td>User Name:</td><td><form:input path="username" value="${user.getUsername()}" pattern=".{8,}" title="Eight or more characters"/></td></tr>
                <tr><td>Password:</td><td><form:password path="password" value="${user.getPassword()}" pattern=".{8,}" title="Eight or more characters" /></td></tr>
                <tr><td>Full name:</td><td><form:input path="fullName" value="${user.getFullName()}" /></td></tr>
                <tr><td>ID card number:</td><td><form:input path="idCardNumber" value="${user.getIdCardNumber()}" /></td></tr>
                <tr><td>ID card type:</td><td><form:input path="idCardType" value="${user.getIdCardType()}" /></td></tr>
                <tr><td>Address:</td><td><form:input path="address" value="${user.getAddress()}" /></td></tr>
                <tr><td>Description:</td><td><form:input path="description" value="${user.getDescription()}" /></td></tr>
                <tr><td><input type="submit" value="Register" /></td></tr>
            </table>
        </form:form>
        </div>
    </body>
</html>