import React from 'react'
import Customer_navbar from './Customer_navbar'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';
import Customer_order_items from './Customer_order_items';


function Order_history() {


  const [orderhistory, setorderhistory] = useState([]);


  useEffect(() => {
    let customer = JSON.parse(sessionStorage.getItem("user"));
    console.log("custid: " + customer.id)
    axios.get("http://localhost:8080/myorder/orderhistory/" + customer.id)
      .then(response => {
        console.log(response.data);
        setorderhistory(response.data);
        sessionStorage.setItem("orderhistory", JSON.stringify(response.data))
      })
      .catch(err => {
        console.log(err);
      })


  }, []);



  return (
    <div>

      <Customer_navbar />
      <h3>Order History</h3>
      <hr /><br />

      {
        orderhistory.map((c) => {
          return (
            <div>
              <h2>Total Order</h2>
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

                <tbody>
                  <tr>
                    <th scope="row">{c.id}</th>
                    <td>{c.orderPrice}</td>
                    <td>{c.orderDate}</td>
                    <td>{c.deliveryDate}</td>
                    <td>{c.orderStatus}</td>
                  </tr>
                </tbody>
              </table>

              <br />
              <Customer_order_items order={c.id} />
              <br />
              <hr /><hr />
              <br /><br /><br /><br />
            </div>
          )
        })
      }
    </div>
  )
}

export default Order_history