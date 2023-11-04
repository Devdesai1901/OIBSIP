import React from "react";
import { Link } from "react-router-dom";


import '../App.css'; // Import your CSS file for styling

const Dashboard = () => {
    return (
        <div className="app">
            <div className="content">
                <div className="center-box">
                    <h1>User Dashboard</h1>
                    {/* <p>Click a button to go to a different page:</p> */}
                    <div className="button-container">
                        <Link to="../Bookings" >
                            <button id="userbutton">Book Ticket </button>
                        </Link>


                        <Link to="../pnrs"  >
                            <button id="adminbutton">Cancel Ticket</button>
                        </Link>

                    </div>
                </div>
            </div>
        </div>
    );
}
export default Dashboard;
