import React from 'react'
import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
const Signup = (props) => {

  const navigate = useNavigate();
  const [data, setData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    contactNo: "",
    role:"",
    line1:"",
    line2:"",
    landmark:"",
    city: "",
    district:"",
    state: "",
    pincode: "",
  });

  const changeHandler = (e) => {
    setData((data) => ({
      ...data,
      [e.target.name]: e.target.value
    }));
    console.log(e.target.value)
  }

  const submitData = () => {



    const obj = {
      "firstName": data.firstName,"lastName": data.lastName,"email": data.email, 
      "password": data.password,"contactNo": data.contactNo,"role": data.role,
      "address": {"line1":data.line1,"line2":data.line2,"landmark":data.landmark,"city": data.city,"district":data.district, "state": data.state,"pincode": data.pincode }
      
    }
      console.log(`in submitData:${obj.email} , ${obj.pincode}`)

    axios.post("http://localhost:8080/auth/signup", obj)
          .then(response => {
            console.log("congratulations");
            navigate(`/Signin`);
          })
          .catch(err => {console.log(err)});
    
  }





  return (
    <div>
      
    <form className = "card col-md-6 offset-md-3 offset-md-3">
      
      <div className="form-group">
        <label htmlFor="firstname">First Name</label>
        <input type="text" name="firstName" value={data.firstName} onChange={changeHandler} className="form-control" id="firstname"/>
      </div>

      <div className="form-group">
        <label htmlFor="lastName">Last Name</label>
        <input type="text" name="lastName" value={data.lastName} onChange={changeHandler} className="form-control" id="lastName" />
      </div>

      <div className="form-group">
        <label htmlFor="exampleDropdownFormEmail1">Email address</label>
        <input type="email" name="email" value={data.email} onChange={changeHandler} className="form-control" id="exampleDropdownFormEmail1" placeholder="email@example.com"/>
      </div>

      <div className="form-group">
        <label htmlFor="exampleDropdownFormPassword1">Password</label>
        <input type="password" name="password" value={data.password} onChange={changeHandler} className="form-control" id="exampleDropdownFormPassword1" placeholder="Password"/>
      </div>

      <div className="form-group">
        <label htmlFor="exampleDropdownFormPassword1">Contact No</label>
        <input type="text" name="contactNo" value={data.contactNo} onChange={changeHandler} className="form-control" id="contactno"/>
      </div>

      <label htmlFor="role">Choose a Role:</label>
      <select  id="role" value={data.role} name="role" onChange={changeHandler}>
      <option>Select</option>
      <option value="ROLE_ADMIN">Admin</option>
      <option value="ROLE_DISTRIBUTOR">Distributor</option>
      <option value="ROLE_CUSTOMER">Customer</option>
      <option value="ROLE_DELIVERYPERSON">Delivery Person</option>
      </select>

      <div className="form-group">
        <label htmlFor="exampleDropdownFormPassword1">Address:</label>
      </div>

      <div className="form-group">
        <label htmlFor="line1">Line 1</label>
        <input type="text" value={data.line1} name="line1" onChange={changeHandler} className="form-control" id="line1"/>
      </div>

      <div className="form-group">
        <label htmlFor="line1">Line 2</label>
        <input type="text" value={data.line2} name="line2" onChange={changeHandler} className="form-control" id="line2"/>
      </div>

      <div className="form-group">
        <label htmlFor="landmark">Landmark</label>
        <input type="text" value={data.landmark} name="landmark" onChange={changeHandler} className="form-control" id="landmark" />
      </div>

      <div className="form-group">
        <label htmlFor="city">City</label>
        <input type="text" value={data.city} name="city" onChange={changeHandler} className="form-control" id="city" />
      </div>

      <div className="form-group">
        <label htmlFor="district">District</label>
        <input type="text" value={data.district} name="district" onChange={changeHandler} className="form-control" id="district" />
      </div>

      <div className="form-group">
        <label htmlFor="state">State</label>
        <input type="text" value={data.state} name="state" onChange={changeHandler} className="form-control" id="state" />
      </div>

      <div className="form-group">
        <label htmlFor="pincode">Pincode</label>
        <input type="number" value={data.pincode} name="pincode" onChange={changeHandler} className="form-control" id="pincode" />
      </div>

        <button type="button" className="btn btn-primary" onClick={submitData}>Sign up</button>

        <div className="dropdown-divider"></div>


    </form>

    </div>
  )
}

export default Signup
