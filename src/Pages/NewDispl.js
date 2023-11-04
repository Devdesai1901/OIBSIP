import React, { useState, useEffect } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import axios from "axios"
import '../App.css';

export default function NewDetails() {
    const [trainNO, setTrainNO] = useState("");
    const [trainName, setTrainName] = useState("");
    const [dest, setDest] = useState("");
    const [arvv, setArvv] = useState("");
    const [pnrdisplay, setPnrDisplay] = useState("");

//    var data1 = localStorage.getItem("data")
//    var parseddata = JSON.parse(data1)
//     console.log(parseddata);

    useEffect(() => {
        // Load data from local storage
        const storedTrainNO = localStorage.getItem("TrainNO");
        const storedTrainName = localStorage.getItem("TrainName");
        const storedDest = localStorage.getItem("dest");
        const storedArvv = localStorage.getItem("Arvv");
        const storedPnrDisplay = localStorage.getItem("pnrdisplay");

        // Update the state with the loaded data
        setTrainNO(storedTrainNO || "");
        setTrainName(storedTrainName || "");
        setDest(storedDest || "");
        setArvv(storedArvv || "");
        setPnrDisplay(storedPnrDisplay || "");
    }, []);



    return (
        <div className="app">
            <div className="content">
                <div className="center-box">
                    <h1>Ticket Details</h1>
                    <form>
                        <div className="form-group">
                            <input
                                type="text"
                                id="TrainNO"
                                name="TrainNO"
                                //placeholder="Train Number"
                                value={trainNO}
                                readOnly
                            />
                        </div>
                        <br />
                        <div className="form-group">
                            <input
                                type="text"
                                id="TrainName"
                                name="TrainName"
                                //placeholder="TrainName"
                                value={trainName}
                                readOnly
                            />
                        </div>
                        <br />
                        <div className="form-group">
                            <input
                                type="text"
                                id="dest"
                                name="dest"
                                //placeholder="Destination of Depature"
                                value={dest}
                                readOnly
                            />
                        </div>
                        <br />
                        <div className="form-group">
                            <input
                                type="text"
                                id="Arvv"
                                name="Arvv"
                                //placeholder="Destination of Arrival"
                                value={arvv}
                                readOnly
                            />
                        </div>
                        <br />
                        <div className="form-group">
                            <input
                                type="text"
                                id="pnrdisplay"
                                name="pnrdisplay"
                                value={pnrdisplay}
                                readOnly
                            />
                        </div>
                        <br />
                        <div className="button-container">
                            <button type="submit">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );

}
