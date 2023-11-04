import React, { useState } from "react";
import { Link, Navigate, useLocation ,useNavigate} from "react-router-dom";
import axios from "axios"
import '../App.css';

export default function Bookings() {

    const navigate = useNavigate();
    const handleSubmit = async (e) => {
       
        e.preventDefault(e);

        const num = e.target.pnrNo.value;
 
        const obj = {
            pnr:num
        };
        console.log(obj)

        try{
            var res = await axios.post("/dashboard/cancelticket",obj)
            console.log(res)
            

              var  trainNo=res.data.trainNO;
              var pnr= res.data.pnr;
               var arrv=res.data.arrv;
               var dest=res.data.dest;
                var trainName=res.data.trainName;
            
           
            localStorage.setItem("TrainNO",trainNo)
            localStorage.setItem("TrainName",trainName)
            localStorage.setItem("dest",dest)
            localStorage.setItem("Arvv",arrv)
            localStorage.setItem("pnrdisplay",pnr)
           

           // localStorage.setItem("data", JSON.stringify(da));
            navigate("../nDetail")
        }
        catch(err)
        {
            console.error(err)
        }

    }

    return (
        <div className="app">
            <div className="content">
                <div className="center-box">
                    <h1>Cancel Ticket</h1>
                    <form
                        action=""
                        onSubmit={handleSubmit}>

                        <div className="form-group">
                            <input type="Text" id="pnrNo" name="pnrNo" placeholder="Enter Pnr Number" />
                        </div>
                        <br />
                       
                        <div className="button-container">
                            
                                <button type="submit">Proceed</button>
                           
                        </div>
                    </form>
                   
                </div>
            </div>
        </div>
    );
}