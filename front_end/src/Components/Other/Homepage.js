import React from 'react'
import Carousel from "react-bootstrap/Carousel";

import image1 from './Images/tata parts.jpg'
import image2 from "./Images/tata cluch.jpeg";
import image3 from "./Images/air filter.jpeg";

import Menu from './Menu'

const Homepage = () => {
  return (
    <div>

      <Menu></Menu>

      <Carousel interval={1500}>
          <Carousel.Item>
            <img className="d-block w-100" src={image1} alt="First slide" style={{ height: "400px" }} />
            <Carousel.Caption>


            </Carousel.Caption>
          </Carousel.Item>
          <Carousel.Item>
            <img className="d-block w-100" src={image2} alt="Second slide" style={{ height: "400px" }} />
            <Carousel.Caption>

            </Carousel.Caption>
          </Carousel.Item>
          <Carousel.Item>
            <img className="d-block w-100" src={image3} alt="Third slide" style={{ height: "400px" }} />
            <Carousel.Caption>


            </Carousel.Caption>
          </Carousel.Item>
        </Carousel>

    </div>
  )
}

export default Homepage
