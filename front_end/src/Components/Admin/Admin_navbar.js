import React from 'react'
import { Link } from 'react-router-dom'
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownItem from 'react-bootstrap/esm/DropdownItem';
import DropdownMenu from 'react-bootstrap/esm/DropdownMenu';


function Admin_navbar() {
  return (

    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav mr-auto">


          <li className="nav-item"><Link className="nav-link" to="/home">E-Spare Store</Link></li>
          <li className="nav-item"><Link className="nav-link">    </Link></li>
          <li className="nav-item"><Link className="nav-link" to="/admin">Admin</Link></li>
          <li className="nav-item"><Link className="nav-link">    </Link></li>


          <li className="nav-item">
          <Dropdown>
          <Dropdown.Toggle variant="light" id="dropdown-basic">List</Dropdown.Toggle>
          <Dropdown.Menu>
             <Link className="nav-link" to="/admin/admin_list">Admin</Link>
             <Link className="nav-link" to="/admin/distributor_list">Distributor</Link>
             <Link className="nav-link" to="/admin/deliveryperson_list">DeliveryPerson</Link>
             <Link className="nav-link" to="/admin/customer_list">Customer</Link>
           </Dropdown.Menu>
           </Dropdown>
           </li>


           <li className="nav-item"><Link className="nav-link">    </Link></li>


          <li className="nav-item">
           <Dropdown>
           <Dropdown.Toggle variant="light" id="dropdown-basic">Operations</Dropdown.Toggle>
           <Dropdown.Menu>
             <Link className="nav-link" to="/admin/category_operations">Category</Link>
             <Link className="nav-link" to="/admin/product_operations">Product</Link>
             <Link className="nav-link" to="/admin/vehicle_operations">Vehicle</Link>
             <Link className="nav-link" to="/admin/image_operations">Image</Link>
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

        
      );
    }
    
   





export default Admin_navbar