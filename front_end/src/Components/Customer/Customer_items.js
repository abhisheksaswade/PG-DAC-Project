import React from 'react'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';
import swal from "sweetalert";

function Customer_items(props) {

  const [cart_item, setcart_item] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/itemdetails/cart_items/" + props.order)
      .then(response => {
        console.log(response.data);
        setcart_item(response.data);
      })
      .catch(err => {
        console.log(err);
      })

  }, [props]);


  const deleteproduct = (itemdetailsId) => {
    
    console.log("delete itemDetails: "+ itemdetailsId);
    axios.delete("http://localhost:8080/itemdetails/" + itemdetailsId)
      .then(response => {
        console.log("this responce of delete: " + response.data)
        swal("Cart item deleted successfully............")
          .then((yes) => {
            if (yes) {
              window.location.reload();
            }
          })


      })
      .catch(err => { console.log(err) 
        swal("Failed to delete cart item............")
      });

  }


  return (
    <div>
      <h2>Cart Details</h2>
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
          cart_item.map((c) => {

            return (
              <tbody>
                <tr>
                  <th scope="row">{c.id}</th>
                  <td>{c.supplierProduct.products.productName}</td>
                  <td>{c.supplierProduct.products.partNumber}</td>
                  <td>{c.price}</td>
                  <td>{c.quantity}</td>
                  <td>{c.supplierProduct.distributor.firstName} {c.supplierProduct.distributor.lastName}</td>


                  <td><button type="button" class="btn btn-danger" onClick={() => deleteproduct(c.id)}>Delete</button></td>
                </tr>


              </tbody>
            )
          })

        }

      </table>

    </div>
  )
}

export default Customer_items