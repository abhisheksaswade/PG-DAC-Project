import React from 'react'
import { BrowserRouter, Link, Route } from 'react-router-dom'
import { useState } from 'react';
import { useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import swal from "sweetalert";
// import Switch from 'react-dom'
const Signin = (props) => {
  const navigate = useNavigate();

  const [data,setData] = useState({
    email:"",
    password:"",
    loginerror:""
  });

  const [passType, setPassType] = useState("text");
  const [isChecked, setIsChecked] = useState(false);

  useEffect(()=>{
    // loadCaptchaEnginge(6,'red','black','upper'); 
   },[])
   const handleShowPassword=()=>{
    setIsChecked(!isChecked);
  }

  useEffect(()=>{
    if(isChecked==true){
        setPassType("text");
        return;
    }
    setPassType("password");
  },[isChecked])

  const changeHandler = (e) => {
    setData((data)=>({
        ...data,
        [e.target.name]:e.target.value
    }));
  }


  const submitData=(e)=>{
      if(data.email == '') {
        alert('email cannot be null');
        return;
      }
      if(data.password == '') {
        alert('Password cannot be null');
        return;
      }
      e.preventDefault();

      const obj = {"email": data.email,"password": data.password}
      axios.post("http://localhost:8080/auth/signin", obj)
        .then(response => {
          console.log(response.data);
          console.log("Role"+response.data.role)
          console.log("Id"+response.data.id)
          if(response.data.role.includes("ROLE_CUSTOMER")){
            sessionStorage.setItem("user",JSON.stringify(response.data))
            navigate(`/Customer`);
          }

          if(response.data.role.includes("ROLE_DISTRIBUTOR")){
            sessionStorage.setItem("user",JSON.stringify(response.data))
            navigate(`/Distributor`);
          }

          if(response.data.role.includes("ROLE_ADMIN")){
            sessionStorage.setItem("user",JSON.stringify(response.data))
            navigate(`/Admin`);
          }

          if(response.data.role.includes("ROLE_DELIVERYPERSON")){
            sessionStorage.setItem("user",JSON.stringify(response.data))
            navigate(`/Deliveryperson`);
          }

          const obj1 = obj; 

        })
        .catch(err => {

        swal("Wrong Details You were Entered","Enter Correct Details again, Make Sure you are registered before Login","error");

        })
        
  }


    
  


  return (

  <div>
    <form className = "card col-md-6 offset-md-3 offset-md-3">
      <div className="form-group">
        <label htmlfor="exampleDropdownFormEmail1">Email address</label>
        <input type="email" name="email" value={data.username} onChange={changeHandler} className="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com"/>
      </div>

      <div className="form-group">
        <label htmlfor="exampleDropdownFormPassword1">Password</label>
        <input type={passType} name="password" value={data.password} onChange={changeHandler} 
        className="form-control" id="exampleDropdownFormPassword1" placeholder="Password"/>
        <span><input type="checkbox" checked={isChecked} onChange={handleShowPassword} style={{'marginLeft':'150px'}} id="show">
          </input>&emsp;</span><label htmlFor="show">Show Password</label>
      </div>


      <button type="submit" className="btn btn-primary" onClick={submitData}>Sign in</button>

        <div className="dropdown-divider"></div>
        <a className="dropdown-item" href="#">New around here?</a>

      <button type="submit" className="btn btn-primary" onClick={() => navigate("/Signup")}>Sign up</button>
      <br></br>
      <button className="btn btn-danger" onClick={(props) => navigate("/")}>Cancel</button> 

      </form>

     </div>


   
  )
}

export default Signin
