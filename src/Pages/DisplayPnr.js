import React, { useState ,useEffect} from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import axios from "axios"
import '../App.css';


export default function DisplayPnr()
{
    // const  location = useLocation();
    // const { pnrNum } = location.state
    //  const [pnr_display, setPnr_Display] = state("");
    //  setPnr_Display(da.pnrNum)
    const [pnrdisplay, setPnrDisplay] = useState("");
    var num = localStorage.getItem("key")
    console.log(num)
    useEffect((pnrdisplay) =>{
        {
            setPnrDisplay(num);
        }
        
    })
    

   
    return (
        <div className="app">
            <div className="content">
                <div className="center-box">
                    <h1>PNR Number</h1>
                    <form
                        // action=""
                        // onSubmit={handleSubmit}
                        >


                        <div className="form-group">
                            <input type="text" id="pnrdisplay" name="pnrdisplay" readOnly value= {pnrdisplay} />
                        </div>
                        <br />
                       
                        <div className="button-container">

                            <Link to="../Dashboard">
                                <button type="submit">Submit</button>
                           </Link>



                        </div>
                    </form>
                   
                </div>
            </div>
        </div>
    )
    
}