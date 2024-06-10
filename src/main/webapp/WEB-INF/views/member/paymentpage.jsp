<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포인트 구매</title>
    <link rel="stylesheet" href="styles.css">
</head>
<style>
    body {
        background-color: #f5f5f5;
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .container {
        background-color: white;
        width: 400px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }

    header {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    header h1 {
        font-size: 18px;
        margin: 0;
    }

    .history-button {
        background-color: transparent;
        border: 1px solid #ccc;
        border-radius: 4px;
        padding: 5px 10px;
        cursor: pointer;
    }

    .product-info {
        margin-top: 20px;
    }

    .product-info h2 {
        font-size: 20px;
        margin: 0;
    }

    .total-amount {
        color: #555;
        margin-top: 10px;
    }

    .total-amount span {
        font-weight: bold;
    }

    .payment-methods {
        margin-top: 20px;
    }

    .payment-methods h3 {
        font-size: 16px;
        margin: 0;
    }

    .methods {
        display: flex;
        flex-wrap: wrap;
        gap: 10px;
        margin-top: 10px;
    }

    .method {
        background-color: #f5f5f5;
        border: 1px solid #ccc;
        border-radius: 4px;
        padding: 10px 20px;
        cursor: pointer;
        flex: 1;
        text-align: center;
    }

    .method.selected {
        border-color: #007bff;
        background-color: #e7f1ff;
    }

    .agreement {
        margin-top: 20px;
    }

    .agreement input[type="checkbox"] {
        margin-right: 10px;
    }

    .agreement p {
        color: #555;
        font-size: 12px;
    }

    .purchase-button {
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        padding: 10px 0;
        width: 100%;
        margin-top: 20px;
        cursor: pointer;
        font-size: 16px;
    }

    .purchase-button:disabled {
        background-color: #ccc;
        cursor: not-allowed;
    }

</style>
<body>
<div class="container">
    <header>
        <h1>웃긴 고등학교</h1>
    </header>
    <div class="product-info">
        <h2>Point ${point}개</h2>
        <c:if test="${point == 5000}">
            <p class="total-amount">총 상품 금액 <span>5,000 원</span></p>
        </c:if>
        <c:if test="${point == 12000}">
            <p class="total-amount">총 상품 금액 <span>10,000 원</span></p>
        </c:if>
        <c:if test="${point == 25000}">
            <p class="total-amount">총 상품 금액 <span>20,000 원</span></p>
        </c:if>
        <c:if test="${point == 35000}">
            <p class="total-amount">총 상품 금액 <span>30,000 원</span></p>
        </c:if>
    </div>
    <div class="payment-methods">
        <h3>결제 수단 선택</h3>
        <div class="methods">
            <button class="method" onclick="selectMethod('카카오페이')">카카오페이</button>
            <button class="method" onclick="selectMethod('네이버페이')">네이버페이</button>
            <button class="method" onclick="selectMethod('신용/체크카드')">신용/체크카드</button>
            <button class="method" onclick="selectMethod('휴대폰')">휴대폰</button>
            <button class="method" onclick="selectMethod('PAYCO')">PAYCO</button>
            <button class="method" onclick="selectMethod('컬쳐랜드상품권')">컬쳐랜드상품권</button>
        </div>
    </div>
    <div class="agreement">
        <input type="checkbox" id="agree" onclick="togglePurchaseButton()">
        <label for="agree">(필수) 구매조건 확인 및 결제진행, 결제대행 서비스 약관에 모두 동의합니다.</label>
        <p>구매 후 7일이 경과하였거나 상품 수령 혹은 상품 사용 시, 청약 철회가 불가능합니다.<br>
            법정대리인의 동의없이 진행한 미성년자의 결제는 취소할 수 있습니다.</p>
    </div>
    <form method="post" action="/member/buy-points">

    <c:if test="${point == 5000}">
    <button  type="submit" class="purchase-button" id="purchaseButton" disabled name="point" value="5000">5,000 원 결제하기</button>
    </c:if>
    <c:if test="${point == 12000}">
        <button  type="submit" class="purchase-button" id="purchaseButton" disabled name="point" value="12000">10,000 원 결제하기</button>
    </c:if>
    <c:if test="${point == 25000}">
        <button  type="submit" class="purchase-button" id="purchaseButton" disabled name="point" value="25000">20,000 원 결제하기</button>
    </c:if>
    <c:if test="${point == 35000}">
        <button  type="submit" class="purchase-button" id="purchaseButton" disabled name="point" value="35000">30,000 원 결제하기</button>
    </c:if>
    </form>

</div>

<script src="scripts.js"></script>
</body>
</html>
<script>
    let selectedMethod = null;

    function selectMethod(method) {
        selectedMethod = method;
        document.querySelectorAll('.method').forEach(button => {
            button.classList.remove('selected');
        });
        event.target.classList.add('selected');
        togglePurchaseButton();
    }

    function togglePurchaseButton() {
        const agreeCheckbox = document.getElementById('agree');
        const purchaseButton = document.getElementById('purchaseButton');
        if (selectedMethod && agreeCheckbox.checked) {
            purchaseButton.disabled = false;
        } else {
            purchaseButton.disabled = true;
        }
    }

</script>

