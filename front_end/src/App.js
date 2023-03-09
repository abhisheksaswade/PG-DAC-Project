import logo from './logo.svg';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {Route,Router,Routes,BrowserRouter, Switch} from 'react-router-dom'


import Homepage from './Components/Other/Homepage';
import Aboutus from './Components/Other/Aboutus';
import Contactus from './Components/Other/Contactus';
import Update from './Components/Other/Update'


import Signup from './Components/Signing/Signup';
import Signin from './Components/Signing/Signin';
import Signout from './Components/Signing/Signout'


import Admin from './Components/Admin/Admin';
import Admin_list from './Components/Admin/Admin_list';
import Distributor_list from './Components/Admin/Distributor_list';
import Deliveryperson_list from './Components/Admin/Deliveryperson_list'
import Customer_list from './Components/Admin/Customer_list'
import Category_operation from './Components/Admin/Category_operation'
import Product_operation from './Components/Admin/Product_operation'
import Vehicle_operation from './Components/Admin/Vehicle_operation'
import Image_operation from './Components/Admin/Image_operation'


import DeliveryPerson from './Components/New_delivery_person/DeliveryPerson'
import Currentdeliveryorder from './Components/New_delivery_person/Currentdeliveryorder'
import DeliveryHistory from './Components/New_delivery_person/DeliveryHistory'


import Distributor from './Components/Distributor/Distributor';
import Dist_product from './Components/Distributor/Dist_product'
import Dist_supplierproduct from './Components/Distributor/Dist_supplierproduct'
import Dist_order from './Components/Distributor/Dist_order'
import Dist_orderhistory from './Components/Distributor/Dist_orderhistory'


import Customer from './Components/Customer/Customer'
import Customer_cart from './Components/Customer/Customer_cart'




function App() {
  return (
    
    <div>
      <BrowserRouter>
      <Routes>

      
      <Route path="/" element={<Homepage/>}></Route>
      <Route path="/home" element={<Homepage/>}></Route>
      <Route path="/aboutus"element={<Aboutus/>}></Route>
      <Route path="/contactus"element={<Contactus/>}></Route>
      <Route path="/update"element={<Update/>}></Route>


      <Route path="/signup"element={<Signup/>}></Route>
      <Route path="/signin"element={<Signin/>}></Route>
      <Route path="/signout"element={<Signout/>}></Route>


      <Route path="/admin"element={<Admin/>}></Route>
      <Route path="/admin/admin_list"element={<Admin_list/>}></Route>
      <Route path="/admin/distributor_list"element={<Distributor_list/>}></Route>
      <Route path="/admin/deliveryperson_list"element={<Deliveryperson_list/>}></Route>
      <Route path="/admin/customer_list"element={<Customer_list/>}></Route>
      <Route path="/admin/category_operations"element={<Category_operation/>}></Route>
      <Route path="/admin/product_operations"element={<Product_operation/>}></Route>
      <Route path="/admin/vehicle_operations"element={<Vehicle_operation/>}></Route>
      <Route path="/admin/image_operations"element={<Image_operation/>}></Route>


      <Route path="/deliveryperson"element={<DeliveryPerson/>}></Route>
      <Route path="/deliveryperson/Currentdeliveryorder"element={<Currentdeliveryorder/>}></Route>
      <Route path='/deliveryperson/deliveryhistory'element={<DeliveryHistory/>}></Route>


      <Route path="/distributor"element={<Distributor/>}></Route>
      <Route path='/distributor/product' element={<Dist_product/>}></Route>
      <Route path='/distributor/supplierproduct' element={<Dist_supplierproduct/>}></Route>
      <Route path='/distributor/currentorder' element={<Dist_order/>}></Route>
      <Route path='/distributor/orderhistory' element={<Dist_orderhistory/>}></Route>


      <Route path="/customer"element={<Customer/>}></Route>
      <Route path="/customer/cart"element={<Customer_cart/>}></Route>


      </Routes>

      </BrowserRouter>
    </div>

  
  );
}

export default App;

