import React from 'react'
import Admin_navbar from './Admin_navbar';
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';

function Distributor_list() {

  const [allDistributorList, setallDistributorList] = useState([]);


    useEffect(() => {
    
      axios.get("http://localhost:8080/user/admin/"+"ROLE_DISTRIBUTOR")
      .then(response =>{
          console.log(response.data);
          setallDistributorList(response.data);       
      })
      .catch(err =>{
        console.log(err);
      })
  
  
    },[]);
  return (
    <div>
      
      <Admin_navbar/>
     
      <table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Email</th>
      <th scope="col">Contact Number</th>
      <th scope="col">Role</th>
      {/* <th scope="col">Line1</th>
      <th scope="col">Line2</th> */}
      <th scope="col">Landmark</th>
      <th scope="col">City</th>
      <th scope="col">District</th>
      <th scope="col">State</th>
      <th scope="col">Pincode</th>
    </tr>
  </thead>

  {
    allDistributorList.map((v) => {

      return(

        <tbody>
        <tr>
        <th scope="row">{v.id}</th>
        <td>{v.firstName}</td>
        <td>{v.lastName}</td>
        <td>{v.email}</td>
        <td>{v.contactNo}</td>
        <td>{v.role}</td>
        {/* <td>{v.address.line1}</td>
        <td>{v.address.line2}</td> */}
        <td>{v.address.landmark}</td>
        <td>{v.address.city}</td>
        <td>{v.address.district}</td>
        <td>{v.address.state}</td>
        <td>{v.address.pincode}</td>

        {/* <td><button type="button" class="btn btn-danger">Delete</button></td> */}
        </tr> 

    
        </tbody>
        )
    })
      
  } 
</table>
    
    </div>
  )
}

export default Distributor_list