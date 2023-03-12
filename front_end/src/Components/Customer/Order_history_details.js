import React from 'react'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';



function Order_history_details(props) {

  const [orderhistorydetails, setorderhistorydetails] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/itemdetails/cart_items/" + props.order)
      .then(response => {
        console.log(response.data);
        setorderhistorydetails(response.data);
      })
      .catch(err => {
        console.log(err);
      })

  }, [props]);



  return (
    <div>
      <h2>Order Details</h2>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Id</th>
            <th scope="col">Product Name</th>
            <th scope="col">Part Number</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Distributor Name</th>
          </tr>
        </thead>

        {
          orderhistorydetails.map((c) => {

            return (
              <tbody>
                <tr>
                  <th scope="row">{c.id}</th>
                  <td>{c.supplierProduct.products.productName}</td>
                  <td>{c.supplierProduct.products.partNumber}</td>
                  <td>{c.price}</td>
                  <td>{c.quantity}</td>
                  <td>{c.supplierProduct.distributor.firstName} {c.supplierProduct.distributor.lastName}</td>
                </tr>
              </tbody>
            )
          })}
      </table>

    </div>
  )
}

export default Order_history_details