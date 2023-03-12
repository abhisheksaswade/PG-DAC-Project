import React from 'react'
import Customer_navbar from './Customer_navbar'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';
import Customer_items from './Customer_items'
import swal from "sweetalert";


function Customer_cart() {

  const [cart, setcart] = useState([]);
  const [payment, setpayment] = useState([]);

  useEffect(() => {
    let customer = JSON.parse(sessionStorage.getItem("user"));
    console.log("custid: " + customer.id)
    axios.get("http://localhost:8080/myorder/cart/" + customer.id)
      .then(response => {
        console.log(response.data);
        setcart(response.data);
        sessionStorage.setItem("cart", JSON.stringify(response.data))

      })
      .catch(err => {
        console.log(err);
      })

  }, []);


  const placeorder = () => {

    let cart = JSON.parse(sessionStorage.getItem("cart"));
    if (cart.orderPrice > 0) {

      axios.put("http://localhost:8080/myorder/orderplace/" + cart.id)
        .then(response => {
          console.log("this order place response: " + response.data)

          swal("Order placed successfully............")
            .then((yes) => {
              if (yes) {
                window.location.reload();
              }

            })


          const paymentObj = {
            "myOrder": {
              "id": cart.id
            }
          }

          console.log("this is paymentObj: " + paymentObj);

          axios.post("http://localhost:8080/payment", paymentObj)
            .then(response => {
              console.log(response.data);
              setpayment(response.data);
            })
            .catch(err => {
              console.log(err);
            })

        })
        .catch(err => {
          console.log(err)

          swal("Failed to place an order............")

        });
    }
    else {
      swal("Atleast one item must be added in cart to place order............")
    }
  }


  return (
    <div>

      <Customer_navbar />
      <h3>Cart</h3>
      <hr /><br />

      <h2>Total Cart</h2>
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
              <th scope="row">{cart.id}</th>
              <td>{cart.orderPrice}</td>
              <td>{cart.orderDate}</td>
              <td>{cart.deliveryDate}</td>
              <td>{cart.orderStatus}</td>

              <td><button type="button" class="btn btn-primary" onClick={placeorder}>Place Order</button></td>
            </tr>
          </tbody>

        }
      </table>
      <br /><br />
      <Customer_items order={cart.id} />

    </div>
  )
}

export default Customer_cart