import React from 'react'
import { useState, useEffect  } from 'react';
import { useNavigate } from 'react-router-dom';
const Customer = (props) => {

  const navigate = useNavigate();
  const [state, setState] = useState({
    firstName: "",
    lastName: "",


  });
  
  useEffect(() => {
    let customer = JSON.parse(sessionStorage.getItem("customer"));
    setState({
    firstName: customer.firstName, lastName: customer.lastName,
    role:customer.role,message:customer.message
    })

  },[]);



  const logout = () => {
  sessionStorage.removeItem("customer");
  navigate("/");
  }

  return (
    <div>
  
    <div className="container" style={{ marginBottom: "50px" }}>
                <div className="row my-3">
                    <div className="col-sm-3" ><h2 className="">Hello, {state.lastName} {state.role} {state.message}</h2></div>

                    <div className="col-sm-6">
                        <button onClick={logout} style={{ "float": "right" }} className="btn btn-danger">Logout </button>
                    </div>
                </div>
    </div>

    </div>
  )
}

export default Customer