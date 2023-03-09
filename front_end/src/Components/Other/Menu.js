import { BrowserRouter, Link,Route,Switch,Router, Routes } from 'react-router-dom';


const Menu = () => {
  return (

    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="collapse navbar-collapse" id="navbarSupportedContent">
        <ul className="navbar-nav mr-auto">
          <li className="nav-item"><Link className="nav-link" to="/home">E-Spare Store</Link></li>
          <li className="nav-item"><Link className="nav-link" to="/aboutus">Aboutus</Link></li>
          <li className="nav-item"><Link className="nav-link" to="/contactus">Contactus</Link></li>
          <li className="nav-item"><Link className="nav-link" to="/signin">Signin</Link></li>
            {/* <li class="nav-item"><Link className="nav-link" to="/Signup">Signup</Link></li> */}

            {/* <li className="nav-item dropdown">
            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Dropdown
            </a>
            <div className="dropdown-menu" aria-labelledby="navbarDropdown">
            <a className="dropdown-item" href="#">Action</a>
            <a className="dropdown-item" href="#">Another action</a>
            <div className="dropdown-divider"></div>
            <a className="dropdown-item" href="#">Something else here</a>
            </div>
            </li> */}

        </ul>
{/* 
          <form className="form-inline my-2 my-lg-0">

            <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"></input>
            <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>

          </form> */}

      </div>

    </nav> 
  );
}
export default Menu;