import React, { Component } from "react";
import classnames from "classnames";

export class AddCapability extends Component {
  render() {
    const errors = {};
    return (
      <div className="card mb-3">
        <div className="card-header bg-primary text-light">Add Capability</div>
        <div className="card-body">
          <form>
            <div className="form-group">
              <label htmlFor="name">Technology Stack</label>
              <input
                type="text"
                name="techStack"
                value=""
                className={classnames("form-control form-control-lg", {
                  "is-invalid": errors.techStack
                })}
              />
              {errors.techStack && (
                <div className="invalid-feedback">{errors.techStack}</div>
              )}
            </div>
            <div className="form-group">
              <label htmlFor="email">Total Developers in Capability</label>
              <input
                type="number"
                name="numOfDevelopers"
                value=""
                className={classnames("form-control form-control-lg", {
                  "is-invalid": errors.numOfDevelopers
                })}
              />
              {errors.email && (
                <div className="invalid-feedback">{errors.email}</div>
              )}
            </div>
            <div className="form-group">
              <label htmlFor="name">Available developers for hire</label>
              <input
                type="number"
                name="numOfAvailableDevelopers"
                value=""
                className="form-control form-control-lg"
              />
            </div>
            <input
              type="submit"
              value="Add Capability"
              className="btn btn-primary btn-block"
            />
          </form>
        </div>
      </div>
    );
  }
}

export default AddCapability;
