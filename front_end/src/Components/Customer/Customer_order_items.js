import React from 'react'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';



function Customer_order_items(props) {

  const [order_item, setorder_item] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/itemdetails/cart_items/" + props.order)
      .then(response => {
        console.log(response.data);
        setorder_item(response.data);
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
          order_item.map((c) => {

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

export default Customer_order_items