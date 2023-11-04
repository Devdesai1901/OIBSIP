import React, { useState, useEffect } from "react";
import { Link, useLocation,useNavigate } from "react-router-dom";
import axios from "axios"
import '../App.css';

export default function Bookings() {

    const [trainNo, setTrainNo] = useState("");
    const [trainName, setTrainName] = useState("");

   const navigate = useNavigate()


   
      var pnrNum= ""
      var res =""
   
  
    const handleSubmit = async (e) =>
     {
        
        e.preventDefault(e);
        
        navigate("../DsPnr", {state: {pnrNum}})

    }
    

    useEffect(() => {
        if (trainNo) {
            fetchTrainNameFromAPI(trainNo);
           
        }
        
    }, [trainNo]);

    // const fetchTrainNameFromAPI = (trainNo) => {
    //   axios.get("/trainName/num/"+ trainNo)
    //         .then(response => {
    //             setTrainName(response.data.trainName);
    //             pnrNum = response.data.pnr
               

    //             console.log(pnrNum)
              
    //         })
    //         .catch(error => {
    //             console.error("Error fetching train name:", error);
    //         });
           
    // }; 

    const fetchTrainNameFromAPI = (trainNo) => {
        res= axios.get("/trainName/num/" + trainNo)
        .then(res =>{
            setTrainName(res.data.trainName)
            pnrNum = res.data.pnr
            console.log(pnrNum)
            localStorage.setItem("key" , pnrNum)
            
        })
            .catch(error => {
                console.error("Error fetching train name:", error);
           });

    }
   
    //console.log(res)
    // data.pnrNum = res.pnr
    // console.log(data)

    return (
        <div className="app">
            <div className="content">
                <div className="center-box">
                    <h1>Ticket Booking</h1>
                    <form
                         action=""
                         onSubmit={handleSubmit}
                        >

                        <div className="form-group">
                            <input type="Text" id="TrainNO" name="TrainNo" placeholder="Train Number" value={trainNo}
                                onChange={(e) => setTrainNo(e.target.value)} />
                        </div>
                        <br />
                        <div className="form-group">
                            <input type="Text" id="TrainName" name="TrainName" placeholder="TrainName" value={trainName}
                                readOnly />
                        </div>
                        <br />
                        

                        <div className="form-group">
                            <input type="date" id="date" />
                        </div>
                       
                        <br />

                        <div className="form-group">
                            <input type="Text" id="TrainName" name="TrainName" placeholder="TrainName" />
                        </div>
                        <br />
                        <div className="form-group">
                            <input type="text" id="dest" name="dest" placeholder="Destination of Depature" />
                        </div>
                        <br />
                        <div className="form-group">
                            <input type="text" id="Arvv" name="Arvv" placeholder="Destination of Arrival" />
                        </div>
                        <br />
                        <select
                            className="form-group "
                            name="ClassType"
                            id="ClassType"
                            aria-label="Default select example"
                        >
                            <option selected>Select Class Type</option>
                            <option value="Gen">General</option>
                            <option value="Sle">Sleeper</option>
                            <option value="Thr">3 Tier AC</option>
                            <option value="Sec">2 Tier AC</option>
                            <option value="Fir">1 Tier AC</option>
                        </select>
                        <br />

                        <div className="button-container">
                           
                                <button type="submit">Insert</button>
                        </div>
                    </form>
                   
                </div>
            </div>
        </div>
    );
}