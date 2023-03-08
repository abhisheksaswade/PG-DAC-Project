import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {Route,Router,Routes,BrowserRouter, Switch} from 'react-router-dom'
import Aboutus from './Components/Aboutus';
import Signup from './Components/Signup';
import Signin from './Components/Signin';
import Contactus from './Components/Contactus';
import Homepage from './Components/Homepage';
import Menu from './Components/Menu';
import Customer from './Components/Customer';
import Distributor from './Components/Distributor';
import Admin from './Components/Admin';
import Deliveryperson from './Components/DeliveryPerson';

function App() {
  return (
    
    <div>
      <BrowserRouter>
      <Menu></Menu>

      <Routes>
      <Route path="/" element={<Homepage/>}></Route>
      <Route path="/Home" element={<Homepage/>}></Route>
      <Route path="/Signin"element={<Signin/>}></Route>
      <Route path="/Signup"element={<Signup/>}></Route>
      <Route path="/Aboutus"element={<Aboutus/>}></Route>
      <Route path="/Contactus"element={<Contactus/>}></Route>
      <Route path="/Customer"element={<Customer/>}></Route>
      <Route path="/Distributor"element={<Distributor/>}></Route>
      <Route path="/Admin"element={<Admin/>}></Route>
      <Route path="/Deliveryperson"element={<Deliveryperson/>}></Route>

      </Routes>
      </BrowserRouter>

    </div>

    
     

    //REady Code
      // <div className="App">
      // <BrowserRouter>

      // <Menubar></Menubar>

      // <div>
      // <Switch>
      
      // <Route path="/Aboutus" component={Aboutus}></Route>
      // <Route path="/Signin" component={Signin}></Route>

      // </Switch>
      // </div>

      // </BrowserRouter>
      // </div>
  );
}

export default App;

