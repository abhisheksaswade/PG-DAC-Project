import React from 'react'
import { Link } from 'react-router-dom'
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownItem from 'react-bootstrap/esm/DropdownItem';
import DropdownMenu from 'react-bootstrap/esm/DropdownMenu';

function Dist_navbar() {
  return (

      <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav mr-auto">


          <li className="nav-item"><Link className="nav-link" to="/home">E-Spare Store</Link></li>
          <li className="nav-item"><Link className="nav-link">    </Link></li>
          <li className="nav-item"><Link className="nav-link" to="/distributor">Distributor</Link></li>
          <li className="nav-item"><Link className="nav-link">    </Link></li>

          <li className="nav-item">
          <Dropdown>
          <Dropdown.Toggle variant="light" id="dropdown-basic">List</Dropdown.Toggle>
          <Dropdown.Menu>
             <Link className="nav-link" to="/distributor/product">Product</Link>
             <Link className="nav-link" to="/distributor/supplierproduct">Supplier Product</Link>
             <Link className="nav-link" to="/distributor/currentorder">Current Order</Link>
             <Link className="nav-link" to="/distributor/orderhistory">Order History</Link>
           </Dropdown.Menu>
           </Dropdown>
           </li>


          <li className="nav-item"><Link className="nav-link">    </Link></li>


          <li className="nav-item">
           <Dropdown>
           <Dropdown.Toggle variant="light" id="dropdown-basic">Profile</Dropdown.Toggle>
           <Dropdown.Menu>
           <Link className="nav-link" to="/update">Update</Link>
           <Link className="nav-link" to="/signout">Sign Out</Link>
            </Dropdown.Menu>
            </Dropdown>
          </li>

        </ul>
      </div>
    </nav> 
    

  )
}

export default Dist_navbar