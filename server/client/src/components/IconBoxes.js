import React from "react";

import Icon1 from "./images/icon_1.svg"; 
import Icon2 from "./images/icon_2.svg";
import Icon3 from "./images/icon_3.svg"; 

class IconBox extends React.Component {
    
    constructor(props) {
        super(props);
    }
    
    render() {
        return (
            <div className="col-lg-4 icon_box_col">
                <div className="icon_box">
                    <div className="icon_box_image"><img src={this.props.image} alt="" /></div>
                    <div className="icon_box_title">{this.props.title}</div>
                    <div className="icon_box_text">
                        <p>{this.props.text}</p>
                    </div>
                </div>
            </div>
        );
    }
}

class IconBoxes extends React.Component {
    render() {
        return (
            <div className="icon_boxes">
                    <div className="container">
                        <div className="row icon_box_row">
                            <IconBox image={Icon1} 
                                     title="Free Shipping Worldwide"
                                     text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie." />

                            <IconBox image={Icon2} 
                                     title="Free Returns"
                                     text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie." />

                            <IconBox image={Icon3} 
                                     title="24h Fast Support"
                                     text="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie." />
                        </div>
                    </div>
                </div>
        );
    }
}

export default IconBoxes;