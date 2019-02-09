import React, { Component } from "react";

class Header extends Component {
  render() {
    return (
      <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-3 py-0">
        <div className="container">
          <a href="/" className="navbar-brand">
            {"Capability Dashboard"}
          </a>
          <div className="navbar-nav mr-0">
            <li className="nav-item">
              <a href="/" className="nav-link">
                Sample link item
              </a>
            </li>
          </div>
        </div>
      </nav>
    );
  }
}

export default Header;
