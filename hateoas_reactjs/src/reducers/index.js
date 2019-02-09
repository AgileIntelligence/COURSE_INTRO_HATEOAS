import { combineReducers } from "redux";
import capabilityReducer from "./capabilityReducer";

export default combineReducers({
  capability: capabilityReducer
});
