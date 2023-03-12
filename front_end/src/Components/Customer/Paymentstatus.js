import React from 'react'
import { useEffect } from "react";
import { useState } from "react";
import axios from 'axios';


function Paymentstatus(props) {

  const [paymentstatus, setpaymentstatus] = useState();
  const [paymentmode, setpaymentmode] = useState();

  useEffect(() => {

    axios.get("http://localhost:8080/payment/getpaymentbyorder/" + props.myorder.id)
      .then(response => {
        console.log(response.data);
        setpaymentstatus(response.data.paymentStatus);
        setpaymentmode(response.data.paymentMode);
      })
      .catch(err => {
        console.log(err);
      })


  }, [ ]);


  return (
    <div>{paymentstatus} & {paymentmode}</div>
  )
}

export default Paymentstatus