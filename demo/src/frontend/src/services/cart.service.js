import http from "../http-common";
class CartService {
getbyId(cid) {
    return http.get(`/auth/cart/${cid}`, cid);
    }
  getAll(username) {
    return http.get(`/auth/cart/list/${username}`, username);
  }
  create(cartData) {
    return http.post("/auth/cart/add", cartData);
  }                                            
  updateCart(cid, cart) {
    return http.put(`/auth/cart/modify/${cid}`, cart);
  }
  delete(cid) {
    return http.delete(`/auth/cart/delete/${cid}`);
  }

  deleteByUsername(username) {
    return http.delete(`/auth/cart/deleteall/${username}`);
  }
 
}
export default new CartService();