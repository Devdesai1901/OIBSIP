import React, { useState } from "react";
import { Link, useLocation,useNavigate } from "react-router-dom";
import axios from"axios"
import '../App.css';

export default function Login() {
    const navigate = useNavigate();
    const handleSubmit = async (e) =>
    {
        e.preventDefault(e);
        
        const name = e.target.userEmail.value;
        const pass= e.target.userPassword.value;

        const obj = {
            email:name,
            password:pass
          };
        console.log(obj);

          try {
             const res = await axios.post("/reservation/signin", obj);
              
              if(res.statusText == "OK")
              {
                  navigate("../Dashboard")
              }
              alert("successful!! Login");
            } catch (err) {
              alert(err);
            }
    }
    return (
        <div className="app">
            <div className="content">
                <div className="center-box">
                    <h1>Booking Login</h1>
                    <form
                        action=""
                        onSubmit={handleSubmit}>

                        <div className="form-group">
                            <input type="email" id="userEmail" name="userEmail" placeholder="Enter Email" />
                        </div>
                        <br />
                        <div className="form-group">
                            <input type="password" id="userPassword" name="userPassword" placeholder="Enter Password" />
                        </div>
                        <br />

                        <div className="button-container">
                          
                                <button type="submit">Login</button>
                         
                        </div>
                    </form>
                    <p>Forget Password?, <a href="#">forgotPassword?</a></p>
                </div>
            </div>
        </div>
    );
}