import React from "react";
import Carousel from "react-bootstrap/Carousel";

class HomeContainer extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Carousel>
                <Carousel.Item>
                    <div className="home">
                        <div className="home_container">
                            <div className="home_background" style={{ backgroundImage: `url("https://shopperstar.s3.amazonaws.com/home_slider_1.jpg")` }}></div>
                            <div className="home_content_container">
                                <div className="container">
                                    <div className="row">
                                        <div className="col">
                                            <div className="home_slider_content" data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                <div className="home_slider_title">Welcome to ShopperStar</div>
                                                <div className="home_slider_subtitle">See Our Products</div>
                                                <div className="button button_light home_button"><a href="/products">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                </Carousel.Item>
                <Carousel.Item>
                    <div className="home">
                            <div className="home_container">
                                <div className="home_background" style={{ backgroundImage: `url("https://shopperstar.s3.amazonaws.com/home_slider_2.jpg")` }}></div>
                                <div className="home_content_container">
                                    <div className="container">
                                        <div className="row">
                                            <div className="col">
                                                <div className="home_slider_content" data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                    <div className="home_slider_title">Welcome to ShopperStar</div>
                                                    <div className="home_slider_subtitle">See Our Products</div>
                                                    <div className="button button_light home_button"><a href="/products">Shop Now</a></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>                    
                </Carousel.Item>
                <Carousel.Item>
                    <div className="home">
                            <div className="home_container">
                                <div className="home_background" style={{ backgroundImage: `url("https://shopperstar.s3.amazonaws.com/home_slider_3.jpg")` }}></div>
                                <div className="home_content_container">
                                    <div className="container">
                                        <div className="row">
                                            <div className="col">
                                                <div className="home_slider_content" data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                    <div className="home_slider_title">Welcome to ShopperStar</div>
                                                    <div className="home_slider_subtitle">See Our Products</div>
                                                    <div className="button button_light home_button"><a href="/products">Shop Now</a></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                </Carousel.Item>
            </Carousel>
        );
    }
}

export default HomeContainer;