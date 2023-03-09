import React from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import mystore from '../Customer/Store';


function Signout() {


  const navigate = useNavigate();

  const logout = () => {
    mystore.dispatch({ type: 'LOGGEDOUT' });
  
    sessionStorage.removeItem("user");
  
    navigate('/');
  }


  return (

        <div className="container" style={{ marginBottom: "50px" }}>
            <div className="row my-3">
                <div className="col-sm-6">
                    <h2>Are you sure you want to Sign Out?</h2>
                    <button onClick={logout} style={{ "float": "right" }} className="btn btn-danger">Sign Out </button>
                 </div>
            </div>   
        </div>

  )
}


export default Signout