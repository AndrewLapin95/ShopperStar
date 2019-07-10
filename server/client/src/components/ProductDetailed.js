import React from 'react'; 

import Detail1 from "./images/details_1.jpg"; 
import Detail2 from "./images/details_2.jpg"; 
import Detail3 from "./images/details_3.jpg"; 
import Detail4 from "./images/details_4.jpg"; 

class DetailsContent extends React.Component { 
    render() { 
        return (
            <div class="details_content">
                <div class="details_name">Smart Phone</div>
                <div class="details_discount">$890</div>
                <div class="details_price">$670</div>

                <div class="in_stock_container">
                    <div class="availability">Availability:</div>
                    <span>In Stock</span>
                </div>
                <div class="details_text">
                    <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. Phasellus id nisi quis justo tempus mollis sed et dui. In hac habitasse platea dictumst.
                        Suspendisse ultrices mauris diam. Nullam sed aliquet elit. Mauris consequat nisi ut mauris efficitur lacinia.</p>
                </div>

                <div class="product_quantity_container">
                    <div class="product_quantity clearfix">
                        <span>Qty</span>
                        <input id="quantity_input" type="text" pattern="[0-9]*" value="1" />
                        <div class="quantity_buttons">
                            <div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fa fa-chevron-up" aria-hidden="true"></i></div>
                            <div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fa fa-chevron-down" aria-hidden="true"></i></div>
                        </div>
                    </div>
                    <div class="button cart_button"><a href="#">Add to cart</a></div>
                </div>

                <div class="details_share">
                    <span>Share:</span>
                    <ul>
                        <li><a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                    </ul>
                </div>
            </div>
        ); 
    } 
}

class DetailsImage extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div class="details_image">
                <div class="details_image_large"><img src={this.props.image1} alt="" />
                    <div class="product_extra product_new"><a href="categories.html">New</a></div>
                </div>
                <div class="details_image_thumbnails d-flex flex-row align-items-start justify-content-between">
                    <div class="details_image_thumbnail active" data-image={this.props.image1}><img src={this.props.image1} alt="" /></div>
                    <div class="details_image_thumbnail" data-image={this.props.image2}><img src={this.props.image2} alt="" /></div>
                    <div class="details_image_thumbnail" data-image={this.props.image3}><img src={this.props.image3} alt="" /></div>
                    <div class="details_image_thumbnail" data-image={this.props.image4}><img src={this.props.image4} alt="" /></div>
                </div>
            </div>            
        );
    }
}

class ProductDetailed extends React.Component { 
    
    render() { 
        return (
            <div class="super_container">
                <div class="product_details">
                    <div class="container">
                        <div class="row details_row">

                            <div class="col-lg-6">
                                <DetailsImage image1={Detail1}
                                              image2={Detail2}
                                              image3={Detail3}
                                              image4={Detail4} />
                            </div>

                            <div class="col-lg-6">
                                <DetailsContent />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        ); 
    } 
} 

export default ProductDetailed;