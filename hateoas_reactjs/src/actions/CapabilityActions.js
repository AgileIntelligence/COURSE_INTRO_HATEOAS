import axios from "axios";
import { GET_CAPABILITIES } from "./ActionTypes";

export const getAllCapabilities = () => async dispatch => {
  const res = await axios.get("http://localhost:8080/dashboard");

  dispatch({
    type: GET_CAPABILITIES,
    payload: res.data._embedded.capabilityList
  });
};
