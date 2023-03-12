import React from 'react'
import ProductList from './ProductList';
import User_info from '../Signing/User_info'
import Customer_navbar from './Customer_navbar'
import Search_product from '../Customer/Search_product'


const Customer = (props) => {

  return (
    <div>   
        <Customer_navbar/>
        <User_info/><br/><br/>
        {/* <Search_product/> */}
        <ProductList></ProductList>
    </div>
  )
}

export default Customer