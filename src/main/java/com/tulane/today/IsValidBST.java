package com.tulane.today;

import com.tulane.base.TreeNode;

/**
 * Created by Tulane
 * 2019/10/31
 */
//TODO 要重看!
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return _isValidBST(root, null, null);
    }

    private boolean _isValidBST(TreeNode root, Integer down, Integer up) {
        if(root == null) return true;
        if(up != null && root.val >= up) return false;
        if(down != null && root.val <= down) return false;

        if(!_isValidBST(root.left, down, root.val)) return false;
        if(!_isValidBST(root.right, root.val, up)) return false;
        return true;
    }
}
