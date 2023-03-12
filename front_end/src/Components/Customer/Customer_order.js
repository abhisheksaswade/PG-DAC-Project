import React from 'react'
import Customer_navbar from './Customer_navbar'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';
import Customer_order_items from './Customer_order_items';
import { Link } from 'react-router-dom'
import Dropdown from 'react-bootstrap/Dropdown';
import swal from "sweetalert";
import Paymentstatus from './Paymentstatus'


function Customer_order() {

  const [myorder, setmyorder] = useState([]);


  useEffect(() => {
    let customer = JSON.parse(sessionStorage.getItem("user"));
    console.log("custid: " + customer.id)
    axios.get("http://localhost:8080/myorder/mycurrentorders/" + customer.id)
      .then(response => {
        console.log(response.data);
        setmyorder(response.data);
        sessionStorage.setItem("myorder", JSON.stringify(response.data))
      })
      .catch(err => {
        console.log(err);
      })


  }, []);


  const deleteorder = (orderId) => {

    axios.delete("http://localhost:8080/myorder/" + orderId)
      .then(response => {
        console.log("this responce of delete order: " + response.data)
        swal("Order cancelled successfully............")
          .then((yes) => {
            if (yes) {
              window.location.reload();
            }
          })


      })
      .catch(err => {
        console.log(err)
        swal("Failed to cancel order............")
      });

  }



  const makepayment = (paymentmode, orderId) => {

console.log("This are make payment args: paymentmode= "+paymentmode+" orderId= "+orderId);

const obj = {
  "paymentMode": paymentmode,
  "myOrder": {
    "id": orderId
  }
}

    axios.put("http://localhost:8080/payment/makepayment",obj)
      .then(response => {
        console.log("this is responce of make payment: " + response.data)
        swal("Payment done successfully............")
          .then((yes) => {
            if (yes) {
              window.location.reload();
            }
          })


      })
      .catch(err => {
        console.log(err)
        swal("Failed to make payment............")
      });

  }




  return (
    <div>

      <Customer_navbar />
      <h3>Current Orders</h3>
      <hr /><br />


      {
        myorder.map((c) => {
          
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
                    <th scope="col">Payment Status & Mode</th>
                  </tr>
                </thead>

                <tbody>
                  <tr>
                    <th scope="row">{c.id}</th>
                    <td>{c.orderPrice}</td>
                    <td>{c.orderDate}</td>
                    <td>{c.deliveryDate}</td>
                    <td>{c.orderStatus}</td>
                    <td><Paymentstatus myorder={c}/></td>
                    <td>
                      <Dropdown>
                        <Dropdown.Toggle variant="success" id="dropdown-basic">Payment</Dropdown.Toggle>
                        <Dropdown.Menu>
                          <button type="button" class="btn btn-light" onClick={() => makepayment("CASH_ON_DELIVERY",c.id)}>CASH ON DELIVERY</button>
                          <button type="button" class="btn btn-light" onClick={() => makepayment("CARD",c.id)}>CARD</button><br/>
                          <button type="button" class="btn btn-light" onClick={() => makepayment("NEFT",c.id)}>NEFT</button>
                        </Dropdown.Menu>
                      </Dropdown>
                    </td>
                    <td><button type="button" class="btn btn-danger" onClick={() => deleteorder(c.id)}>Cancel Order</button></td>
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

export default Customer_order