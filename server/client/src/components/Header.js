import React, { Component } from 'react'; 
import MainNav from './MainNav';
import UpperLeftPanel from './UpperLeftPanel';

class Header extends Component {
    render() { 
        return (
            <header className="header">
                <div className="header_container">
                    <div className="container">
                        <div className="row">
                            <div className="col">
                                <div className="header_content d-flex flex-row align-items-center justify-content-start">
                                    <div className="logo"><a href="/">ShopperStar</a></div>
                                    <MainNav />
                                    <UpperLeftPanel />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </header>
        ) 
    } 
} 

export default Header;