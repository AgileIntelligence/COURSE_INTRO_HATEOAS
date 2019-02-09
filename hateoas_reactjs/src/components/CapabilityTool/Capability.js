import React, { Component } from "react";

export class Capability extends Component {
  render() {
    return (
      <div className="card card-body border-primary mb-3">
        <h4 className="text-primary">
          Sample Capability
          <i className="fas fa-user-edit ml-2" style={{ color: "blue" }} />
          <i className="fas fa-user-times ml-2" style={{ color: "red" }} />
        </h4>

        <ul className="list-group">
          <li className="list-group-item bg-light text-primary">
            Technology Stack: Sample Tech Stack
          </li>
          <li className="list-group-item bg-light  text-primary">
            Total Developers in Capability: 200
          </li>
          <li className="list-group-item bg-light  text-primary">
            Available developers for hire: 20
          </li>
        </ul>
      </div>
    );
  }
}

export default Capability;
