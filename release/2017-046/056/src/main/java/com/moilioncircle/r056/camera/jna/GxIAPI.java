package com.moilioncircle.r056.camera.jna;

import com.sun.jna.*;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

public interface GxIAPI extends Library {

    GxIAPI API = Native.loadLibrary("GxIAPI", GxIAPI.class);

    //------------------------------------------------------------------------------
//  错误码定义
//------------------------------------------------------------------------------
/*
    typedef enum GX_STATUS_LIST
    {
        GX_STATUS_SUCCESS                =  0,           ///< 成功
        GX_STATUS_ERROR                  = -1,           ///< 不期望发生的未明确指明的内部错误
        GX_STATUS_NOT_FOUND_TL           = -2,           ///< 找不到TL库
        GX_STATUS_NOT_FOUND_DEVICE       = -3,           ///< 找不到设备
        GX_STATUS_OFFLINE                = -4,           ///< 当前设备为掉线状态
        GX_STATUS_INVALID_PARAMETER      = -5,           ///< 无效参数,一般是指针为NULL或输入的IP等参数格式无效
        GX_STATUS_INVALID_HANDLE         = -6,           ///< 无效句柄
        GX_STATUS_INVALID_CALL           = -7,           ///< 无效的接口调用,专指软件接口逻辑错误
        GX_STATUS_INVALID_ACCESS         = -8,           ///< 功能当前不可访问或设备访问模式错误
        GX_STATUS_NEED_MORE_BUFFER       = -9,           ///< 用户申请的buffer不足:读操作时用户输入buffersize小于实际需要
        GX_STATUS_ERROR_TYPE             = -10,          ///< 用户使用的FeatureID类型错误，比如整型接口使用了浮点型的功能码
        GX_STATUS_OUT_OF_RANGE           = -11,          ///< 用户写入的值越界
        GX_STATUS_NOT_IMPLEMENTED        = -12,          ///< 当前不支持的功能
        GX_STATUS_NOT_INIT_API           = -13,          ///< 没有调用初始化接口
        GX_STATUS_TIMEOUT                = -14,          ///< 超时错误
    }GX_STATUS_LIST;
    typedef int32_t GX_STATUS;
*/
    int
            GX_STATUS_SUCCESS = 0,           ///< 成功
            GX_STATUS_ERROR = -1,           ///< 不期望发生的未明确指明的内部错误
            GX_STATUS_NOT_FOUND_TL = -2,           ///< 找不到TL库
            GX_STATUS_NOT_FOUND_DEVICE = -3,           ///< 找不到设备
            GX_STATUS_OFFLINE = -4,           ///< 当前设备为掉线状态
            GX_STATUS_INVALID_PARAMETER = -5,           ///< 无效参数,一般是指针为NULL或输入的IP等参数格式无效
            GX_STATUS_INVALID_HANDLE = -6,           ///< 无效句柄
            GX_STATUS_INVALID_CALL = -7,           ///< 无效的接口调用,专指软件接口逻辑错误
            GX_STATUS_INVALID_ACCESS = -8,           ///< 功能当前不可访问或设备访问模式错误
            GX_STATUS_NEED_MORE_BUFFER = -9,           ///< 用户申请的buffer不足:读操作时用户输入buffersize小于实际需要
            GX_STATUS_ERROR_TYPE = -10,          ///< 用户使用的FeatureID类型错误，比如整型接口使用了浮点型的功能码
            GX_STATUS_OUT_OF_RANGE = -11,          ///< 用户写入的值越界
            GX_STATUS_NOT_IMPLEMENTED = -12,          ///< 当前不支持的功能
            GX_STATUS_NOT_INIT_API = -13,          ///< 没有调用初始化接口
            GX_STATUS_TIMEOUT = -14;          ///< 超时错误

//  句柄定义
//------------------------------------------------------------------------------
/*
    typedef void* GX_DEV_HANDLE;               ///< 设备句柄，通过GXOpenDevice获取，通过此句柄进行控制与采集
    typedef void* GX_EVENT_CALLBACK_HANDLE;    ///< 设备事件回调句柄，注册设备相关事件回调函数，比如设备掉线回调函数
    typedef void* GX_FEATURE_CALLBACK_HANDLE;  ///< 设备属性更新回调句柄，注册设备属性更新回调函数的时候获取
*/

    class GX_DEV_HANDLE extends PointerByReference {
    }

    ;               ///< 设备句柄，通过GXOpenDevice获取，通过此句柄进行控制与采集

    class GX_EVENT_CALLBACK_HANDLE extends PointerByReference {
    }

    ;    ///< 设备事件回调句柄，注册设备相关事件回调函数，比如设备掉线回调函数

    class GX_FEATURE_CALLBACK_HANDLE extends PointerByReference {
    }

    ;  ///< 设备属性更新回调句柄，注册设备属性更新回调函数的时候获取

//------------------------------------------------------------------------------------

/*
#define GX_PIXEL_MONO                  ( 0x01000000 )
#define GX_PIXEL_COLOR                 ( 0x02000000 )

#define GX_PIXEL_8BIT                  ( 0x00080000 )
#define GX_PIXEL_10BIT                 ( 0x000A0000 )
#define GX_PIXEL_12BIT                 ( 0x000C0000 )
#define GX_PIXEL_16BIT                 ( 0x00100000 )
#define GX_PIXEL_24BIT                 ( 0x00180000 )
#define GX_PIXEL_30BIT                 ( 0x001E0000 )
#define GX_PIXEL_32BIT                 ( 0x00200000 )
#define GX_PIXEL_36BIT                 ( 0x00240000 )
#define GX_PIXEL_48BIT                 ( 0x00300000 )
#define GX_PIXEL_64BIT                 ( 0x00400000 )
*/

    int GX_PIXEL_MONO = (0x01000000);
    int GX_PIXEL_COLOR = (0x02000000);
    int GX_PIXEL_8BIT = (0x00080000);
    int GX_PIXEL_10BIT = (0x000A0000);
    int GX_PIXEL_12BIT = (0x000C0000);
    int GX_PIXEL_16BIT = (0x00100000);
    int GX_PIXEL_24BIT = (0x00180000);
    int GX_PIXEL_30BIT = (0x001E0000);
    int GX_PIXEL_32BIT = (0x00200000);
    int GX_PIXEL_36BIT = (0x00240000);
    int GX_PIXEL_48BIT = (0x00300000);
    int GX_PIXEL_64BIT = (0x00400000);

    /*
        typedef enum GX_PIXEL_FORMAT_ENTRY
        {
            GX_PIXEL_FORMAT_UNDEFINED          = (0),
            GX_PIXEL_FORMAT_MONO8              = (GX_PIXEL_MONO  | GX_PIXEL_8BIT  | 0x0001),//0x1080001,
            GX_PIXEL_FORMAT_MONO8_SIGNED       = (GX_PIXEL_MONO  | GX_PIXEL_8BIT  | 0x0002),//0x1080002,
            GX_PIXEL_FORMAT_MONO10             = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0003),//0x1100003,
            GX_PIXEL_FORMAT_MONO12             = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0005),//0x1100005,
            GX_PIXEL_FORMAT_MONO14             = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0025),//0x1100025,
            GX_PIXEL_FORMAT_MONO16             = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0007),//0x1100007,
            GX_PIXEL_FORMAT_BAYER_GR8          = (GX_PIXEL_MONO  | GX_PIXEL_8BIT  | 0x0008),//0x1080008,
            GX_PIXEL_FORMAT_BAYER_RG8          = (GX_PIXEL_MONO  | GX_PIXEL_8BIT  | 0x0009),//0x1080009,
            GX_PIXEL_FORMAT_BAYER_GB8          = (GX_PIXEL_MONO  | GX_PIXEL_8BIT  | 0x000A),//0x108000A,
            GX_PIXEL_FORMAT_BAYER_BG8          = (GX_PIXEL_MONO  | GX_PIXEL_8BIT  | 0x000B),//0x108000B,
            GX_PIXEL_FORMAT_BAYER_GR10         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x000C),//0x110000C,
            GX_PIXEL_FORMAT_BAYER_RG10         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x000D),//0x110000D,
            GX_PIXEL_FORMAT_BAYER_GB10         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x000E),//0x110000E,
            GX_PIXEL_FORMAT_BAYER_BG10         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x000F),//0x110000F,
            GX_PIXEL_FORMAT_BAYER_GR12         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0010),//0x1100010,
            GX_PIXEL_FORMAT_BAYER_RG12         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0011),//0x1100011,
            GX_PIXEL_FORMAT_BAYER_GB12         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0012),//0x1100012,
            GX_PIXEL_FORMAT_BAYER_BG12         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0013),//0x1100013,
            GX_PIXEL_FORMAT_BAYER_GR16         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x002E),//0x110002E,
            GX_PIXEL_FORMAT_BAYER_RG16         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x002F),//0x110002F,
            GX_PIXEL_FORMAT_BAYER_GB16         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0030),//0x1100030,
            GX_PIXEL_FORMAT_BAYER_BG16         = (GX_PIXEL_MONO  | GX_PIXEL_16BIT | 0x0031),//0x1100031,
            GX_PIXEL_FORMAT_RGB8_PLANAR        = (GX_PIXEL_COLOR | GX_PIXEL_24BIT | 0x0021),//0x2180021,
            GX_PIXEL_FORMAT_RGB10_PLANAR       = (GX_PIXEL_COLOR | GX_PIXEL_48BIT | 0x0022),//0x2300022,
            GX_PIXEL_FORMAT_RGB12_PLANAR       = (GX_PIXEL_COLOR | GX_PIXEL_48BIT | 0x0023),//0x2300023,
            GX_PIXEL_FORMAT_RGB16_PLANAR       = (GX_PIXEL_COLOR | GX_PIXEL_48BIT | 0x0024),//0x2300024,
        }GX_PIXEL_FORMAT_ENTRY;
    */
    int
            GX_PIXEL_FORMAT_UNDEFINED = (0),
            GX_PIXEL_FORMAT_MONO8 = (GX_PIXEL_MONO | GX_PIXEL_8BIT | 0x0001),//0x1080001,
            GX_PIXEL_FORMAT_MONO8_SIGNED = (GX_PIXEL_MONO | GX_PIXEL_8BIT | 0x0002),//0x1080002,
            GX_PIXEL_FORMAT_MONO10 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0003),//0x1100003,
            GX_PIXEL_FORMAT_MONO12 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0005),//0x1100005,
            GX_PIXEL_FORMAT_MONO14 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0025),//0x1100025,
            GX_PIXEL_FORMAT_MONO16 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0007),//0x1100007,
            GX_PIXEL_FORMAT_BAYER_GR8 = (GX_PIXEL_MONO | GX_PIXEL_8BIT | 0x0008),//0x1080008,
            GX_PIXEL_FORMAT_BAYER_RG8 = (GX_PIXEL_MONO | GX_PIXEL_8BIT | 0x0009),//0x1080009,
            GX_PIXEL_FORMAT_BAYER_GB8 = (GX_PIXEL_MONO | GX_PIXEL_8BIT | 0x000A),//0x108000A,
            GX_PIXEL_FORMAT_BAYER_BG8 = (GX_PIXEL_MONO | GX_PIXEL_8BIT | 0x000B),//0x108000B,
            GX_PIXEL_FORMAT_BAYER_GR10 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x000C),//0x110000C,
            GX_PIXEL_FORMAT_BAYER_RG10 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x000D),//0x110000D,
            GX_PIXEL_FORMAT_BAYER_GB10 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x000E),//0x110000E,
            GX_PIXEL_FORMAT_BAYER_BG10 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x000F),//0x110000F,
            GX_PIXEL_FORMAT_BAYER_GR12 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0010),//0x1100010,
            GX_PIXEL_FORMAT_BAYER_RG12 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0011),//0x1100011,
            GX_PIXEL_FORMAT_BAYER_GB12 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0012),//0x1100012,
            GX_PIXEL_FORMAT_BAYER_BG12 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0013),//0x1100013,
            GX_PIXEL_FORMAT_BAYER_GR16 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x002E),//0x110002E,
            GX_PIXEL_FORMAT_BAYER_RG16 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x002F),//0x110002F,
            GX_PIXEL_FORMAT_BAYER_GB16 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0030),//0x1100030,
            GX_PIXEL_FORMAT_BAYER_BG16 = (GX_PIXEL_MONO | GX_PIXEL_16BIT | 0x0031),//0x1100031,
            GX_PIXEL_FORMAT_RGB8_PLANAR = (GX_PIXEL_COLOR | GX_PIXEL_24BIT | 0x0021),//0x2180021,
            GX_PIXEL_FORMAT_RGB10_PLANAR = (GX_PIXEL_COLOR | GX_PIXEL_48BIT | 0x0022),//0x2300022,
            GX_PIXEL_FORMAT_RGB12_PLANAR = (GX_PIXEL_COLOR | GX_PIXEL_48BIT | 0x0023),//0x2300023,
            GX_PIXEL_FORMAT_RGB16_PLANAR = (GX_PIXEL_COLOR | GX_PIXEL_48BIT | 0x0024);//0x2300024,

//------------------------------------------------------------------------------
//  结构体类型定义
//------------------------------------------------------------------------------

/*
#define GX_INFO_LENGTH_8_BYTE   (8)  ///< 8字节
#define GX_INFO_LENGTH_32_BYTE  (32) ///< 32字节
#define GX_INFO_LENGTH_64_BYTE  (64) ///< 64字节
#define GX_INFO_LENGTH_128_BYTE (128)///< 128字节
*/

    int GX_INFO_LENGTH_8_BYTE = (8);  ///< 8字节
    int GX_INFO_LENGTH_32_BYTE = (32); ///< 32字节
    int GX_INFO_LENGTH_64_BYTE = (64); ///< 64字节
    int GX_INFO_LENGTH_128_BYTE = (128);///< 128字节

/*
    typedef struct GX_DEVICE_IP_INFO
    {
        char szDeviceID[GX_INFO_LENGTH_64_BYTE + 4];         ///< 设备唯一标识,如果实际长度超过64字节有效字符串，则只保留64个有效字符
        char szMAC[GX_INFO_LENGTH_32_BYTE];                  ///< MAC地址,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        char szIP[GX_INFO_LENGTH_32_BYTE];                   ///< IP地址,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        char szSubNetMask[GX_INFO_LENGTH_32_BYTE];           ///< 子网掩码,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        char szGateWay[GX_INFO_LENGTH_32_BYTE];              ///< 网关,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        char szNICMAC[GX_INFO_LENGTH_32_BYTE];               ///< 对应网卡的MAC地址,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        char szNICIP[GX_INFO_LENGTH_32_BYTE];                ///< 对应网卡的IP地址,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        char szNICSubNetMask[GX_INFO_LENGTH_32_BYTE];        ///< 对应网卡的子网掩码,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        char szNICGateWay[GX_INFO_LENGTH_32_BYTE];           ///< 对应网卡的网关,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        char szNICDescription[GX_INFO_LENGTH_128_BYTE + 4];  ///< 对应网卡描述,如果实际长度超过128字节有效字符串，则只保留128个有效字符
        char reserved[512];                                  ///< 保留
    }GX_DEVICE_IP_INFO;
*/


    class GX_DEVICE_IP_INFO extends Structure {
        public byte[] szDeviceID = new byte[GX_INFO_LENGTH_64_BYTE + 4];         ///< 设备唯一标识,如果实际长度超过64字节有效字符串，则只保留64个有效字符
        public byte[] szMAC = new byte[GX_INFO_LENGTH_32_BYTE];                  ///< MAC地址,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        public byte[] szIP = new byte[GX_INFO_LENGTH_32_BYTE];                   ///< IP地址,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        public byte[] szSubNetMask = new byte[GX_INFO_LENGTH_32_BYTE];           ///< 子网掩码,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        public byte[] szGateWay = new byte[GX_INFO_LENGTH_32_BYTE];              ///< 网关,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        public byte[] szNICMAC = new byte[GX_INFO_LENGTH_32_BYTE];               ///< 对应网卡的MAC地址,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        public byte[] szNICIP = new byte[GX_INFO_LENGTH_32_BYTE];                ///< 对应网卡的IP地址,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        public byte[] szNICSubNetMask = new byte[GX_INFO_LENGTH_32_BYTE];        ///< 对应网卡的子网掩码,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        public byte[] szNICGateWay = new byte[GX_INFO_LENGTH_32_BYTE];           ///< 对应网卡的网关,如果实际长度超过32字节有效字符串，则只保留31个有效字符
        public byte[] szNICDescription = new byte[GX_INFO_LENGTH_128_BYTE + 4];  ///< 对应网卡描述,如果实际长度超过128字节有效字符串，则只保留128个有效字符
        public byte[] reserved = new byte[512];                                  ///< 保留

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(
                    "szDeviceID",
                    "szMAC",
                    "szIP",
                    "szSubNetMask",
                    "szGateWay",
                    "szNICMAC",
                    "szNICIP",
                    "szNICSubNetMask",
                    "szNICGateWay",
                    "szNICDescription",
                    "reserved"
            );
        }
    }


    //------------------------------------------------------------------------------
//  回调函数类型定义
//------------------------------------------------------------------------------
//----------------------------------------------------------------------------------

//----------------------------------------------------------------------------------

    /**
     * \brief     掉线回调函数定义
     * \param     pUserParam    用户私有参数，注册掉线回调函数的时候传入此参数
     * \return    void
     */
//----------------------------------------------------------------------------------
/*
    typedef void (GX_STDC *GXDeviceOfflineCallBack) (void *pUserParam);
*/
    interface GXDeviceOfflineCallBack extends Callback {
        void invoke(Pointer pUserParam);
    }

    ;

//----------------------------------------------------------------------------------

    /**
     * \brief     枚举所有设备并且获取设备个数,对于千兆网设备此接口能够枚举所有子网内的设备
     * \attention 此接口的作用是更新库内部设备列表，此接口会改变库内部设备列表，
     * 所以调用GXGetAllDeviceBaseInfo和GXOpenDevice之前需要调用此接口。
     * 如果在用户指定超时时间内成功枚举到设备，则立即返回；如果在用户指定超时时间内没有枚举到设备，则一直等待，直到达到用户指定的超时时间返回
     * \param     [out]punNumDevices 返回设备个数
     * \param     [in]unTimeOut      枚举的超时时间(单位ms)。
     * \return    GX_STATUS_SUCCESS             操作成功，没有发生错误
     * GX_STATUS_NOT_INIT_API        没有调用GXInitLib初始化库
     * GX_STATUS_INVALID_PARAMETER   用户输入的指针为NULL
     * 其它错误情况请参见GX_STATUS_LIST
     */
//----------------------------------------------------------------------------------
/*
    GX_API GXUpdateAllDeviceList         (uint32_t* punNumDevices, uint32_t nTimeOut);
*/
    int GXUpdateAllDeviceList(IntByReference punNumDevices, int nTimeOut);

//----------------------------------------------------------------------------------

    /**
     * \brief 通过序号打开设备
     * \param nDeviceIndex 设备序号，从1开始，例如：1、2、3、4...
     * \param phDevice 返回设备句柄
     * \return GX_STATUS,捕获底层调用产生的异常，根据异常类型返回不同的错误码
     */
//----------------------------------------------------------------------------------
/*
    GX_API GXOpenDeviceByIndex        (uint32_t nDeviceIndex, GX_DEV_HANDLE* phDevice);   // 已弃用
*/
    int GXOpenDeviceByIndex(int nDeviceIndex, GX_DEV_HANDLE phDevice); // 已弃用

//----------------------------------------------------------------------------------

    /**
     * \brief     获取设备的永久IP信息
     * \attention 该接口只适用于网络设备
     * \param     [in]       hDevice                  设备句柄
     * \param     [in]       pszIP                    设备永久IP字符串地址
     * \param     [in, out]  pnIPLength               设备永久IP地址字符串长度,单位字节。
     * \param     [in]       pnIPLength:              用户buffer大小
     * \param     [out]      pnIPLength:              实际填充大小
     * \param     [in]       pszSubNetMask            设备永久子网掩码字符串地址
     * \param     [in, out]  pnSubNetMaskLength       设备永久子网掩码字符串长度
     * \param     [in]       pnSubNetMaskLength:      用户buffer大小
     * \param     [out]      pnSubNetMaskLength:      实际填充大小
     * \param     [in]       pszDefaultGateWay        设备永久网关字符串地址
     * \param     [in, out]  pnDefaultGateWayLength   设备永久网关字符串长度
     * \param     [in]       pnDefaultGateWayLength:  用户buffer大小
     * \param     [out]      pnDefaultGateWayLength:  实际填充大小
     * \return    GX_STATUS_SUCCESS             操作成功，没有发生错误
     * GX_STATUS_NOT_INIT_API        没有调用GXInitLib初始化库
     * GX_STATUS_INVALID_PARAMETER   用户输入的指针为NULL
     * 上面没有涵盖到的，不常见的错误情况请参见GX_STATUS_LIST
     */
//----------------------------------------------------------------------------------
/*
    GX_API GXGetDevicePersistentIpAddress (GX_DEV_HANDLE  hDevice,
                                           char* pszIP,
                                           size_t *pnIPLength,
                                           char* pszSubNetMask,
                                           size_t *pnSubNetMaskLength,
                                           char* pszDefaultGateWay,
                                           size_t *pnDefaultGateWayLength);
*/

    int GXGetDevicePersistentIpAddress(Pointer hDevice,
                                       byte[] pszIP,
                                       IntByReference pnIPLength,
                                       byte[] pszSubNetMask,
                                       IntByReference pnSubNetMaskLength,
                                       byte[] pszDefaultGateWay,
                                       IntByReference pnDefaultGateWayLength);

//----------------------------------------------------------------------------------

    /**
     * \brief     设置设备的永久IP信息
     * \attention 该接口只适用于网络设备
     * \param     [in]     hDevice              设备句柄
     * \param     [in]     pszIP                设备永久IP字符串，末尾’\0’
     * \param     [in]     pszSubNetMask        设备永久子网掩码字符串，末尾’\0’
     * \param     [in]     pszDefaultGateWay    设备永久网关字符串，末尾’\0’
     * \return    GX_STATUS_SUCCESS             操作成功，没有发生错误
     * GX_STATUS_NOT_INIT_API        没有调用GXInitLib初始化库
     * GX_STATUS_INVALID_HANDLE      用户传入非法的句柄，或者关闭已经被关闭的设备
     * 其它错误情况请参见GX_STATUS_LIST
     */
//----------------------------------------------------------------------------------
/*
    GX_API GXSetDevicePersistentIpAddress (GX_DEV_HANDLE  hDevice,
									   const char* pszIP,
									   const char* pszSubNetMask,
									   const char* pszDefaultGateWay);
*/
    int GXSetDevicePersistentIpAddress(Pointer hDevice,
                                       String pszIP,
                                       String pszSubNetMask,
                                       String pszDefaultGateWay);

}
