import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Routes, Route,useNavigate } from "react-router-dom";
import React from 'react';
import SignUp from './Pages/SignUp'
import SignIn from './Pages/SignIn'
import Dashboard from './Pages/User_Dashboard'
import Booking from './Pages/TicketBooking'
import Pnr from './Pages/PnrPage'
import Dpnr from './Pages/DisplayPnr'
import Details from './Pages/NewDispl'
function App() {
  return (
    <div className="App">
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
      <BrowserRouter>
        <Routes>
          <Route path="/">
            <Route index element={<SignUp />} />
            <Route exact path="SignIn" element={<SignIn />}/>
            <Route exact path="Dashboard" element={<Dashboard/>}/>
            <Route exact path="Bookings" element={<Booking />} />
            <Route exact path="pnrs" element={<Pnr/>}/>
            <Route exact path="DsPnr" element={<Dpnr/>}/>
            <Route exact path="nDetail" element={<Details/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
