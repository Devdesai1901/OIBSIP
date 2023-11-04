import React, { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import axios from "axios"
import '../App.css';


export default function Signup_User() {

    const navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault();

        const name = e.target.username_user.value;
        const mail_add = e.target.userEmail_user.value;
        const cell = e.target.phone.value;
        const pass = e.target.userPassword_user.value;
        //console.log(obj)

        const obj = {
           
            username:name,
            email:mail_add,
            mobileNo:cell,
            password:pass
        };
        console.log(obj.username);
        console.log(obj.email);
        console.log(obj.mobileNo);
        console.log(obj.password);

        try
        {
            const res = await axios.post("/reservation/signup",obj)
              console.log(obj);
            if (res.statusText == "OK")
            {
                navigate("../SignIn")
            }
              //alert("Registration successful!! You may now login");
        }
        catch(err)
        {
            alert(err);
        }
    };
    return (
        <div className="app">
            <div className="content">
                <div className="center-box">
                    <h1>User SignUp</h1>
                    <form
                    action=""
                    onSubmit={handleSubmit}>


                        <div className="form-group">
                            <input type="text" id="username_user" name="username_user" placeholder="Username" />
                        </div>
                        <br />
                        <div className="form-group">
                            <input type="email" id="userEmail_user" name="userEmail_user" placeholder="User Email" />
                        </div>
                        <br />

                        <div className="form-group">
                            <input type="text" id="phone" name="phone" placeholder="Enter Mobile Number" />
                        </div>
                        <br />
                        <div className="form-group">
                            <input type="password" id="userPassword_user" name="userPassword_user" placeholder="User Password" />
                        </div>
                        <br />

                        <div className="button-container">
                            
                                <button type="submit">Submit</button>
                    
                               

                        </div>
                    </form>
                    <p>If you are already a member, <a href="../SignIn">Sign In</a></p>
                </div>
            </div>
        </div>
    )

}