import React from 'react'
import Delivery_Navbar from './Delivery_Navbar'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function DeliveryHistory() {

  const [deliveryHistoryList, setDeliveryHistoryList] = useState([]);
  var navigate = useNavigate();

  useEffect(() => {
    let deliveryHistoryList = JSON.parse(sessionStorage.getItem("user"));

    axios.get("http://localhost:8080/myorder/deliverylist/"+deliveryHistoryList.id)
    .then(response =>{
        console.log(response.data);
        setDeliveryHistoryList(response.data);

     
    })
    .catch(err =>{
      console.log(err);
    })


  },[]);
  return (
    <div>
      <Delivery_Navbar/>
      DeliveryHistory

      <table class="table">
  <thead>
    <tr>
      <th scope="col">My Order id</th>
      <th scope="col">Order Price</th>
      <th scope="col">Order Date</th>
      <th scope="col">Delivery Date</th>
      <th scope="col">Order Status</th>
    </tr>
  </thead>

  {
    deliveryHistoryList.map((v) => {

      return(
        <tbody>
        <tr>
        <th scope="row">{v.id}</th>
        <td>{v.orderPrice}</td>
        <td>{v.orderDate}</td>
        <td>{v.deliveryDate}</td>
        <td>{v.orderStatus}</td>
        </tr> 
        </tbody>
        )
    })
      
  }

   
  
</table>


      </div>
  )
}

export default DeliveryHistory