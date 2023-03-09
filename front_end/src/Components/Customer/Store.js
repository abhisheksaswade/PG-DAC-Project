import reducer from "./Reducer";
import { createStore } from "redux";

const IntialState = { loggedin: false };

const mystore = createStore(reducer, IntialState);

export default mystore;