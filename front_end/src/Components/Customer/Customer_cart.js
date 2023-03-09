import React from 'react'
import Customer_navbar from './Customer_navbar'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';

function Customer_cart() {

  const [allProductList, setallProductList] = useState([]);


  useEffect(() => {
    let customer = JSON.parse(sessionStorage.getItem("user"));
    console.log("custid: "+customer.id)
    axios.get("http://localhost:8080/myorder/cart/"+customer.id)
    .then(response =>{
        console.log(response.data);
        setallProductList(response.data);       
    })
    .catch(err =>{
      console.log(err);
    })


  },[]);


  return (
    <div>
      
      <Customer_navbar/>

      <table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Order Price</th>
      <th scope="col">Order Date</th>
      <th scope="col">Delivery Date</th>
      <th scope="col">Order Status</th>
    </tr>
  </thead>

  {
    <tbody>
        <tr>
        <th scope="row">{allProductList.id}</th>
        {/* <td>{v.orderPrice}</td>
        <td>{v.orderDate}</td>
        <td>{v.deliveryDate}</td>
        <td>{v.orderStatus}</td> */}

        <td><button type="button" class="btn btn-primary">Give Order</button></td>
        <td><button type="button" class="btn btn-success">Edit</button></td>
        <td><button type="button" class="btn btn-danger">Delete</button></td>
        </tr> 

    
        </tbody>
      
  }

   
  
</table>

      
      Customer_cart
      place order button


      
    </div>
  )
}

export default Customer_cart