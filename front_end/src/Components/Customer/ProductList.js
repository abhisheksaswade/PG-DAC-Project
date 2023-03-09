import React from 'react'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';

function ProductList() {

    const [allProductList, setallProductList] = useState([]);


    useEffect(() => {
      // let allProductList = JSON.parse(sessionStorage.getItem("user"));

      axios.get("http://localhost:8080/supplierproducts")
      .then(response =>{
          console.log(response.data);
          setallProductList(response.data);       
      })
      .catch(err =>{
        console.log(err);
      })
  
  
    },[]);


    const addtocart = (spid) => {
      console.log("prod id: "+spid);
        
      }


  return (
    <div>
       <table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Weight</th>
      <th scope="col">Rating</th>
      <th scope="col">Part Number</th>
      <th scope="col">Price</th>
      <th scope="col">Discount</th>
      <th scope="col">Final Price</th>
      <th scope="col">Quantity</th>
    </tr>
  </thead>

  {
    allProductList.map((c) => {
      let v=c.products;
      console.log("C: "+c);
      console.log("V: "+v);

      return(
        <tbody>
        <tr>
        <th scope="row">{c.id}</th>
        <td>{v.productName}</td>
        <td>{v.description}</td>
        <td>{v.weight}</td>
        <td>{v.rating}</td>
        <td>{v.partNumber}</td>
        <td>{c.price}</td>
        <td>{c.discount}</td>
        <td>{c.finalPrice}</td>
        <td>{c.quantity}</td>

        <td><button type="button" class="btn btn-primary" onClick={() => addtocart(c.id)}>Add to Cart</button></td>
        <td><button type="button" class="btn btn-success">Edit</button></td>
        <td><button type="button" class="btn btn-danger">Delete</button></td>
        </tr> 

    
        </tbody>
        )
    })
      
  }

   
  
</table>
    </div>
  )
}

export default ProductList
